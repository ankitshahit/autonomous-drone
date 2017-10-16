package org.drone.robot.engine.customlisteners.classes;

import org.drone.robot.engine.customlisteners.interfaces.CustomEngineInputListener;
import org.drone.robot.engine.utils.EngineUtils;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;

public class IntelligentInputListener implements CustomEngineInputListener {
	/**
	 * needs some logic to notify the parent object of event change and to get
	 * the value from one of the state changed methods/properties
	 */
	private boolean state;
	private String name;
	private Pin pin;

	@Override
	public boolean stateChanged() {
		return state;
	}

	/**
	 * only notify when there is a state change to high once state is changed
	 * apply a delay of say 100 ms
	 */
	@Override
	public void handleGpioPinDigitalStateChangeEvent(
			GpioPinDigitalStateChangeEvent event) {
		if (event.getState().isHigh() == Boolean.FALSE) {
			return;
		}
		state = EngineUtils.convertToBoolean(event.getState().getValue());
		name = event.getPin().getName();
		pin = event.getPin().getPin();
	}

	/**
	 * need to add null checks as well.
	 */
	@Override
	public String pinName() {
		return name;
	}

	/**
	 * need to add null checks as well.
	 */

	@Override
	public int raspiPinAddress() {
		return pin.getAddress();
	}

	/**
	 * need to add null checks as well.
	 */

	@Override
	public Pin getPin() {

		return null;
	}

}
