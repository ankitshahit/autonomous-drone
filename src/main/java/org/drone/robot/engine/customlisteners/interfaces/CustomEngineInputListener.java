package org.drone.robot.engine.customlisteners.interfaces;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * This listener need to be extended.. it will have our own custom fuctions as
 * well to notify the main program of state change or additional trigger
 * 
 * @author Ankit
 * 
 */

public interface CustomEngineInputListener extends GpioPinListenerDigital {
	public boolean stateChanged();

	public String pinName();

	public int raspiPinAddress();
	
	public Pin getPin();

}
