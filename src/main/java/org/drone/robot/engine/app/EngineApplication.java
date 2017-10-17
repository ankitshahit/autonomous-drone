package org.drone.robot.engine.app;

import org.drone.robot.engine.exception.GpioException;
import org.drone.robot.engine.factory.Pi4jFactory;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class EngineApplication {
	public static void main(String[] args) throws GpioException,
			InterruptedException {

		System.out.println("Total number of output address(es) provided: "
				+ args[0]);

		Integer[] address = new Integer[args.length];
		for (int index = 0; index < args.length; index++) {
			address[index] = Integer.parseInt(args[index]);
		}

		GpioPinDigitalOutput[] outputPins = new GpioPinDigitalOutput[address.length];

		outputPins = Pi4jFactory.registerAllDigitalOutputPins(address);
		System.out.println("output : " + outputPins.length);
		for (GpioPinDigitalOutput gpioPinDigitalOutput : outputPins) {
			System.out.println("inside loop");
			gpioPinDigitalOutput.high();
			Thread.sleep(300);
			gpioPinDigitalOutput.low();
		}

		System.out.println("Terminating program.");
		Pi4jFactory.getInstance().shutdown();
	}
}
