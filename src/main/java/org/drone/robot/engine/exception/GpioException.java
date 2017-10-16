package org.drone.robot.engine.exception;

public class GpioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GpioException() {
		super();
	}

	public GpioException(String msg) {
		super(msg);
	}

	public GpioException(Exception ex) {
		super(ex.getLocalizedMessage());
	}
}
