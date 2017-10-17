package org.drone.robot.engine.app;

import org.drone.robot.engine.exception.GpioException;
import org.drone.robot.engine.factory.Pi4jFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class EngineApplication {
	public static void main(String[] args) throws GpioException,
			InterruptedException {

		System.out.println("Total number of output address(es) provided: "
				+ args[0]);

		Integer[] address = new Integer[args.length];
		for (int index = 0; index < args.length; index++) {
			address[index] = Integer.parseInt(args[index]);
		}
		GpioController controller = GpioFactory.getInstance();
		GpioPinDigitalOutput output = controller
				.provisionDigitalOutputPin(RaspiPin.GPIO_24);

		System.out.println("toggling state");
		output.toggle();
		System.out.println("Sleeping thread for 300 milliseconds");

		Thread.sleep(300);
		System.out.println("setting it to high");
		output.high();
		System.out.println("Sleeping thread for 300 milliseconds");
		Thread.sleep(300);
		GpioFactory.getInstance().shutdown();
		/*
		 * GpioPinDigitalOutput[] outputPins = new
		 * GpioPinDigitalOutput[address.length];
		 * 
		 * outputPins = Pi4jFactory.registerAllDigitalOutputPins(address);
		 * System.out.println("output : " + outputPins.length); for
		 * (GpioPinDigitalOutput gpioPinDigitalOutput : outputPins) {
		 * System.out.println("inside loop"); gpioPinDigitalOutput.high();
		 * Thread.sleep(300); gpioPinDigitalOutput.low(); }
		 * 
		 * System.out.println("Terminating program.");
		 * Pi4jFactory.getInstance().shutdown();
		 */
	}
}
