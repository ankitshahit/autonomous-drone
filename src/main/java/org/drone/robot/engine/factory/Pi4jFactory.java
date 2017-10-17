package org.drone.robot.engine.factory;

import java.util.List;

import org.drone.robot.engine.exception.GpioException;
import org.drone.robot.engine.views.GeneralGpioView;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Pi4jFactory {
	private static GpioController controller;

	public static <T> void validateConvertToAddressPin(Integer[] address)
			throws GpioException {
		validateIfNull(address);

	}

	public static <T> void validateAddress(T[] address) throws GpioException {
		validateIfNull(address);
		if (address.length < 0) {
			throw new GpioException(
					"Length of pins to be converted is less than 0");
		}
		if (address.length > 41) {
			throw new GpioException(
					"Length of pins to be converted is greater than number of available pins on pi 3");
		}

	}

	public static <T> void validateIfNull(T value) throws GpioException {
		if (value == null)
			throw new GpioException("Value provided is empty.");
	}

	public static Pin getPinByAddress(int val) {
		Pin pin = RaspiPin.getPinByAddress(val);
		return pin;
	}

	/**
	 * @throws GpioException
	 * @param address
	 * @param length
	 * @return
	 */
	public static Pin[] convertAddressToPin(Integer[] address)
			throws GpioException {
		validateConvertToAddressPin(address);

		Pin[] raspiPins = new Pin[address.length];
		try {
			Pin pin = null;
			for (int index = 0; index < address.length; index++) {
				pin = getPinByAddress(index);
				raspiPins[index] = pin;
			}

		} catch (Exception ex) {
			throw new GpioException(ex);
		}
		return raspiPins;
	}

	/**
	 * Gpio Controller should only be a singleton object throughout jvm
	 * 
	 * @return
	 */
	public static GpioController getInstance() {
		if (controller == null) {
			controller = GpioFactory.getInstance();
		}
		return controller;
	}

	/**
	 * GPIOCOntroller need to be shutdown at the end of execution.
	 */
	public static void consumeGpioFactory() {
		if (controller == null) {
			return;
		}
		controller.shutdown();
	}

	public static GpioPinDigitalInput reserveGpioPinAsDigitalInputBy(Pin pin) {
		if (controller == null) {
			getInstance();
		}

		return controller.provisionDigitalInputPin(pin, pin.getName());
	}

	public static GpioPinDigitalOutput reserveGpioPinDigitalOutput(Pin pin) {
		if (controller == null) {
			getInstance();
		}
		return controller.provisionDigitalOutputPin(pin);
	}

	public static void addListenerToDigitalPin(GpioPinDigitalInput input,
			GpioPinListenerDigital listener) {
		input.addListener(listener);
	}

	public static void addListenerToDigitalPin(GpioPinDigitalInput input,
			List<GpioPinListenerDigital> listener) {
		input.addListener(listener);

	}

	public static void removeAllListener(GpioPinDigitalInput input) {
		input.removeAllListeners();
	}

	public static void removeListener(GpioPinInput input,
			List<GpioPinListenerDigital> listener) {
		input.removeListener(listener);

	}

	public static GpioPinDigitalInput registerDigitalInputPin(
			GeneralGpioView view) {
		return reserveGpioPinAsDigitalInputBy(view.getPin());
	}

	public static GpioPinDigitalOutput[] registerAllDigitalOutputPins(
			Integer[] address) throws GpioException {
		validateConvertToAddressPin(address);
		Pin[] pins = convertAddressToPin(address);
		GpioPinDigitalOutput[] outputRegistered = new GpioPinDigitalOutput[pins.length];
		GpioPinDigitalOutput registeredPin = null;
		for (int index = 0; index < pins.length; index++) {
			registeredPin = reserveGpioPinDigitalOutput(pins[index]);
			outputRegistered[index] = registeredPin;
		}
		pins = null;
		registeredPin = null;
		address = null;
		return outputRegistered;
	}

	public static GpioPinDigitalInput[] registerAllDigitalInputPins(
			Integer[] address) throws GpioException {
		validateConvertToAddressPin(address);
		Pin[] pins = convertAddressToPin(address);
		GpioPinDigitalInput[] inputs = new GpioPinDigitalInput[pins.length];
		GpioPinDigitalInput registeredPin = null;
		for (int index = 0; index < pins.length; index++) {
			registeredPin = reserveGpioPinAsDigitalInputBy(pins[index]);
			inputs[index] = registeredPin;
		}
		pins = null;
		registeredPin = null;
		address = null;
		return inputs;
	}

}
