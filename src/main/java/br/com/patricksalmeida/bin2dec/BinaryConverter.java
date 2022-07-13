package br.com.patricksalmeida.bin2dec;

import br.com.patricksalmeida.bin2dec.exception.InvalidBinaryProvidedException;
import br.com.patricksalmeida.bin2dec.exception.InvalidDecimalProvidedException;

import java.util.Objects;

public class BinaryConverter {

	private static final int BASE_OF_BINARY_NUMBERS = 2;

	private BinaryConverter() { }

	public static int fromBinary(String binaryRaw) {
		if (isInvalidBinary(binaryRaw)) {
			throw new InvalidBinaryProvidedException("Invalid binary provided to convert");
		}

		return Integer.parseInt(binaryRaw, BASE_OF_BINARY_NUMBERS);
	}

	public static boolean isInvalidBinary(String binaryRaw) {
		return Objects.isNull(binaryRaw) || binaryRaw.isBlank() || !isValidBinary(binaryRaw);
	}

	public static boolean isValidBinary(String binaryRaw) {
		return binaryRaw.matches("[0-1]+");
	}

	public static String fromDecimal(int randomNumber) {
		if (isNegativeNumber(randomNumber)) {
			throw new InvalidDecimalProvidedException("Invalid decimal provided to convert");
		}

		return Integer.toBinaryString(randomNumber);
	}

	public static boolean isNegativeNumber(int number) {
		return number < 0;
	}

}
