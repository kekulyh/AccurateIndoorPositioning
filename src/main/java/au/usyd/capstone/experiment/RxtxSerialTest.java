/*******************************************************
*	File name: SerialTest
*	Author: Yahong Liu
*	Version: 0.1
*	Date: 27/09/2015
*	Description: Java RXTX read serial input
********************************************************/

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
		
		// Array for storing the input data
		private static String[] ary = {"0", "0", "1", "0", "0", "0"};
		
		// Input data split
		private String a1 = "a1";
		private String a2 = "a2";
		private String a3 = "a3";
		private String g1 = "g1";
		private String g2 = "g2";
		private String g3 = "g3";
		
		public String[] getAry() {
			return ary;
		}

		public void setAry(String[] ary) {
			this.ary = ary;
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
		 * This should be called when you stop using the port. This will prevent port locking on platforms like Linux.
		 */
		public synchronized void close() {
			if (serialPort != null) {
				serialPort.removeEventListener();
				serialPort.close();
			}
		}
		
		/**
		 * Handle an event on the serial port. Read the data and print it.
		 */
		public synchronized void serialEvent(SerialPortEvent serialPortEvent) {
			if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				
				try {
					// 串口监听为有数据时的动作
					String inputLine = input.readLine();
					
					ary = inputLine.split("\\\t");
					
					this.setAry(ary);
					
				} catch (Exception e) {
					System.err.println("serialEvent error: "+e.toString());
				}
				
			};
		}
		

}
