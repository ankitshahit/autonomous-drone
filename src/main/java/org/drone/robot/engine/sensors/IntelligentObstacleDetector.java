/*package org.drone.robot.engine.sensors;

import org.drone.robot.engine.customlisteners.classes.IntelligentInputListener;
import org.drone.robot.engine.factory.Pi4jFactory;
import org.drone.robot.engine.views.GeneralGpioView;

import com.pi4j.io.gpio.GpioPinDigitalInput;

*//**
 * Proximity IR sensors will act as a fail safe to immediately stop the vechile.
 * 
 * @author Ankit
 * 
 *//*
public class IntelligentObstacleDetector {
	// initializes an input from GPIOFactory based upon DI from View.
	private GpioPinDigitalInput input;
	private GeneralGpioView view;

	// dependency injection of view.
	// pass the view to Factory for registering an input?
	public IntelligentObstacleDetector(GeneralGpioView view) {
		super();
		this.view = view;
		this.input = Pi4jFactory.registerDigitalInputPin(this.view);
	}

	*//**
	 * this will somehow return a state to main brain for providing information
	 * related to a blockage.
	 * 
	 * @return
	 *//*
	public void register() {
		// registering a new listener needs to be implemented.
		// creating a custom listener is important, for now a default listener
		// will be attached.
		Pi4jFactory.addListenerToDigitalPin(input,
				new IntelligentInputListener());
		// will need to return something? or to return the value of high/low
		// state incase a listener will be polling?
		return;
	}
}
*/