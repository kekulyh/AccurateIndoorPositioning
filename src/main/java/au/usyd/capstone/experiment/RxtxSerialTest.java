/**************************************************************************
*	File name: RxtxSerialTest
*	Author: Yahong Liu
*	Version: 6.0
*	Date: 01/Nov/2015
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

import au.usyd.capstone.domain.Coordinate;
import au.usyd.capstone.domain.Gesture;

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
	private static OutputStream output;
	// Define timeout milliseconds while waiting for port open
	private static final int TIME_OUT = 2000;
	// Define BAUD rate
	private static final int DATA_RATE = 38400;
	
	/** variables for coordinate calculation */
	// Array for storing the input string data
	private static String[] array = {"0", "0", "1", "0", "0", "0", "0", "0", "0"};
//	// Input data split to string
//	private String a1 = "0";
//	private String a2 = "0";
//	private String a3 = "1";
//	private String g1 = "0";
//	private String g2 = "0";
//	private String g3 = "0";
//	private String m1 = "0";
//	private String m2 = "0";
//	private String m3 = "0";
	
	// gesture
	private static double yaw = 0;
	private static double pitch = 0;
	private static double roll = 0;
	
	public static double getYaw() {
		return yaw;
	}

	public static void setYaw(double yaw) {
		RxtxSerialTest.yaw = yaw;
	}

	public static double getPitch() {
		return pitch;
	}

	public static void setPitch(double pitch) {
		RxtxSerialTest.pitch = pitch;
	}

	public static double getRoll() {
		return roll;
	}

	public static void setRoll(double roll) {
		RxtxSerialTest.roll = roll;
	}


	// static variable for DeviceDaoImpl calling
	// Testing: use the fixed parameters
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
//				char ch = 'R';
//				output.write(ch);

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
	 * Write bytes to OutputStream
	 */
	public synchronized void writeData(String data) {
		 
//		System.out.println("Output Stream: " + data);
		try {
			output.write(data.getBytes());
		} catch (Exception e) {
			System.out.println("could not write to port");
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
//				System.out.println("InputLine: "+ inputLine );
				
				// split data into array
				array = inputLine.split("\\\t");
				
//				// call function for calculation (simple algorithm for testing)
//				Coordinate coordinate = CoordinateCalculation.coordinateCalculation(array[0], array[1], array[2], array[3], array[4], array[5]);
//				
//				// gesture by quaternion (six axis)
//				Gesture gesture = CoordinateCalculation.gestureCalculationWithQuaternionSixAxis(array[0], array[1], array[2], array[3], array[4], array[5]);
				
				
				// gesture by quaternion (nine axis)
				Gesture gesture = CoordinateCalculation.gestureCalculationWithQuaternionNineAxis(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
				// set yaw, pitch, roll ( for DeviceDaoImpl.calculateGesture(device) )
				setYaw(gesture.getYaw());
				setPitch(gesture.getPitch());
				setRoll(gesture.getRoll());
//				System.out.println("Yaw: " + yaw + "Pitch: " + pitch + "Roll: " + roll);
				
				// coordinate by gesture ( for DeviceDaoImpl.calculateCoordinate(device) )
				Coordinate coordinate = CoordinateCalculation.coordinateCalculationWithGesture(gesture, array[0], array[1], array[2], coordinateX, coordinateY);
				// set coordinate
				setCoordinateX(coordinate.getCoordinateX());
				setCoordinateY(coordinate.getCoordinateY());
				
			} catch (Exception e) {
				System.err.println("serialEvent error: "+e.toString());
			}
			
		}
		
	}
	
	
}
