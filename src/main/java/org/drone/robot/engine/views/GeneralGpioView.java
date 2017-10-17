package org.drone.robot.engine.views;

import com.pi4j.io.gpio.Pin;

public class GeneralGpioView {
	private Pin pin;
	private String name;
	private long coords;
	private String direction;
	
	/**
	 * @return the pin
	 */
	public Pin getPin() {
		return pin;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(Pin pin) {
		this.pin = pin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the coords
	 */
	public Long getCoords() {
		return coords;
	}

	/**
	 * @param coords
	 *            the coords to set
	 */
	public void setCoords(Long coords) {
		this.coords = coords;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
