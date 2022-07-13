package br.com.patricksalmeida.bin2dec;

import br.com.patricksalmeida.bin2dec.exception.InvalidBinaryProvidedException;
import br.com.patricksalmeida.bin2dec.exception.InvalidDecimalProvidedException;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/*
* https://github.com/florinpop17/app-ideas/blob/master/Projects/1-Beginner/Bin2Dec-App.md
* project reference
* */
class BinaryConverterTest {

	@Test
	void shouldReceiveOneBinaryByteIntoString() {
		int result = BinaryConverter.fromBinary("11111111");
		assertEquals(255, result);
	}

	@Test()
	void shouldThrowIfParamIsNull() {
		verifyIfThrowsInvalidBinaryProvidedException(null);
	}

	@Test
	void shouldThrowIfParamIsBlank() {
		verifyIfThrowsInvalidBinaryProvidedException("");
	}

	@Test
	void shouldThrowIfParamHasAnyWord() {
		verifyIfThrowsInvalidBinaryProvidedException("ABC");
	}

	@Test
	void shouldThrowIfParamHasInvalidNumbers() {
		verifyIfThrowsInvalidBinaryProvidedException("2");
	}

	private void verifyIfThrowsInvalidBinaryProvidedException(String binaryToCalculate) {
		InvalidBinaryProvidedException exception = assertThrows(InvalidBinaryProvidedException.class,
				() -> BinaryConverter.fromBinary(binaryToCalculate));
		assertEquals("Invalid binary provided to convert", exception.getMessage());
	}

	@Test
	void shouldConvertRandomBinaryToDecimal() {
		int randomDecimal = generateRandomNumber();
		String randomBinary = convertNumberToBinary(randomDecimal);
		int convertedDecimal = BinaryConverter.fromBinary(randomBinary);
		assertEquals(randomDecimal, convertedDecimal);
	}

	@Test
	void shouldReturnBinaryFromDecimal() {
		int decimalToConvert = 1;
		String expectedBinary = convertNumberToBinary(decimalToConvert);
		String convertedBinary = BinaryConverter.fromDecimal(decimalToConvert);
		assertEquals(expectedBinary, convertedBinary);
	}

	@Test
	void shouldThrowsIfReceiveAnNegativeNumber() {
		int decimalNegative = -1;
		InvalidDecimalProvidedException exception = assertThrows(InvalidDecimalProvidedException.class,
				() -> BinaryConverter.fromDecimal(decimalNegative));
		assertEquals("Invalid decimal provided to convert", exception.getMessage());
	}

	@Test
	void shouldConvertRandomDecimalToBinary() {
		int randomDecimal = generateRandomNumber();
		String convertedBinary = BinaryConverter.fromDecimal(randomDecimal);
		int expectedDecimalOrigin = BinaryConverter.fromBinary(convertedBinary);
		assertEquals(expectedDecimalOrigin, randomDecimal);
	}

	public String convertNumberToBinary(int randomNumber) {
		return Integer.toBinaryString(randomNumber);
	}

	private int generateRandomNumber() {
		int randomStartLimit = 0;
		int randomEndLimit = 1000000000;
		return new Random().nextInt(randomEndLimit - randomStartLimit) + randomStartLimit;
	}

}