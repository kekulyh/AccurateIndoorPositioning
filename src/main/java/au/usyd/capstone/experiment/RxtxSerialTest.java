/**************************************************************************
*	File name: RxtxSerialTest
*	Author: Yahong Liu
*	Version: 1.1
*	Date: 27/09/2015
*	Description: Java RXTX read serial input and calculation of coordinate
***************************************************************************/

package au.usyd.capstone.experiment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class RxtxSerialTest implements SerialPortEventListener {
	
	/** variables for reading serial port data */
	// Create serial port
	private SerialPort serialPort;
	// Define local port name
	private static final String PORT_NAMES[] = { 
			"/dev/cu.usbmodem1411", // Mac OS X
			"COM3", // Windows
	};
	// The input stream to the port
	private BufferedReader input;
	// The output stream to the port
	private OutputStream output;
	// Define timeout milliseconds while waiting for port open
	private static final int TIME_OUT = 2000;
	// Define BAUD rate
	private static final int DATA_RATE = 38400;
	
	
	/** variables for coordinate calculation */
	// Array for storing the input string data
	private static String[] array = {"0", "0", "1", "0", "0", "0"};
	// Input data split to string
	private String a1 = "0";
	private String a2 = "0";
	private String a3 = "1";
	private String g1 = "0";
	private String g2 = "0";
	private String g3 = "0";
	// parse string into double
	private double accel1 = 0;
	private double accel2 = 0;
	private double accel3 = 1;
	private double gyro1 = 0;
	private double gyro2 = 0;
	private double gyro3 = 0;
	// current time
	private static long currentTime;
	// sampling time for gyro data
	private static double gyroTime = 1;
	// calculated acceleration data
	private double accel = 0;
	// calculated angle data
	private static double anglex = 0;
	private static double angley = 0;
	// defined step size 
	private double step = 0.95;
	// calculated real next step data
	private double nextStepXReal = 0;
	private double nextStepYReal = 0;
	// converted next step on the UI
	private double nextStepX = 0;
	private double nextStepY = 0;
	// static variable for DeviceDaoImpl calling
	private static double coordinateX = 500;
	private static double coordinateY = 120;
	
	
	/** setter and getter method for coordinate */
	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		RxtxSerialTest.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		RxtxSerialTest.coordinateY = coordinateY;
	}
	
	
	/**
	 * Initialize the serial port.
	 */
	public void initialize() {

		// Define port id
		CommPortIdentifier portId = null;

		// Get enumeration of available port names
		@SuppressWarnings("rawtypes")
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// Find the instance of serial port which set in PORT_NAMES[]
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			// Cannot find the defined port
			System.out.println("Could not find COM port.");
			return;
		}
		
		// Do the initialization work
		try {
			if ( !portId.isCurrentlyOwned() ) {
				// Open serial port, and use class name for the appName
				serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

				// set port parameters
				serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

				// open the streams
				input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
				output = serialPort.getOutputStream();

				// add event listeners
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				
				System.out.println("Port: " + portId.getName() + " initialize" );
			}
			else{
				System.out.println("Port" + portId.getName() + " is currently being used");
			}
			
		} catch (Exception e) {
			System.err.println("initialize() error: "+e.toString());
		}
		
	}
	
	
	/**
	 * Close the port. Prevent port locking on Unix-like system.
	 */
	public synchronized void close() {
		
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
		
	}
	
	
	/**
	 * Event on the serial port. Handle the data.
	 */
	public synchronized void serialEvent(SerialPortEvent serialPortEvent) {
		
		if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			
			try {
				// read line data to string
				String inputLine = input.readLine();
				
				// split data into array
				array = inputLine.split("\\\t");
				
				// set string value
				a1 = array[0];
				a2 = array[1];
				a3 = array[2];
				g1 = array[3];
				g2 = array[4];
				g3 = array[5];
				
				// call function for calculation
				this.coordinateCalculation(a1, a2, a3, g1, g2, g3);
				
			} catch (Exception e) {
				System.err.println("serialEvent error: "+e.toString());
			}
			
		}
		
	}
	
	
	/**
	 * Calculate the coordinate.
	 */
	private void coordinateCalculation(String a1, String a2, String a3, String g1, String g2, String g3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1);
		gyro2 = Double.parseDouble(g2);
		gyro3 = Double.parseDouble(g3);
		
		System.out.println("a1: " + accel1 +" , a2: " + accel2 + " , a3: " + accel3 + " , g1: " + gyro1 + " , g2: " + gyro1 + " , g3: " + gyro3);
		
		// handle acceleration data
		accel = Math.sqrt(Math.pow(accel1, 2) + Math.pow(accel2, 2) + Math.pow(accel3, 2)) - 1;
		
		System.out.println("Acceleration: " + accel);
		
		// set gyro time
		gyroTime =  ( System.currentTimeMillis() - currentTime ) / 1000.0000;
		
		System.out.println("gyroTime: " + gyroTime);
		
		// update current time
		currentTime = System.currentTimeMillis();
		
		// handle gyro data
		anglex += gyro1 * gyroTime;
		angley += gyro2 * gyroTime;
		
		System.out.println("Angle X: " + anglex);
		System.out.println("Angle Y: " + angley);
		
		if (accel >0.25) {
			
			// calculate real next step data
			nextStepXReal = step * Math.cos(anglex);
			nextStepYReal = step * Math.cos(angley);
			
			// convert real data for displaying on UI
			nextStepX = nextStepXReal * 250/12;
			nextStepY = nextStepYReal * 250/12;
			
			System.out.println("nextStepX: " + nextStepX + "nextStepY: " + nextStepY);
			
			// update coordinate
			coordinateX = coordinateX + nextStepX;
			coordinateY = coordinateY + nextStepY;
			
			// initialize the acceleration
			accel = 0;
		}
		
		System.out.println("coordinateX: " + coordinateX + " ,coordinateY: " + coordinateY);
		
		// set the static coordinate variable
		this.setCoordinateX(coordinateX);
		this.setCoordinateY(coordinateY);
		
	}
	

}
