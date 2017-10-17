package org.drone.robot.engine.app;

import org.drone.robot.engine.exception.GpioException;
import org.drone.robot.engine.factory.Pi4jFactory;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class EngineApplication {
	public static void main(String[] args) throws GpioException,
			InterruptedException {
		Integer[] address = new Integer[args.length];
		for (int index = 0; index < args.length; index++) {
			address[index] = Integer.parseInt(args[index]);
		}

		GpioPinDigitalOutput[] outputPins = new GpioPinDigitalOutput[address.length];

		outputPins = Pi4jFactory.registerAllDigitalOutputPins(address);

		for (GpioPinDigitalOutput gpioPinDigitalOutput : outputPins) {
			gpioPinDigitalOutput.blink(300);
			Thread.sleep(300);
		}
	}
}
