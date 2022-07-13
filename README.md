# Bin2Dec
This project it's a simple binary converter, in the main class BinaryConverter we have two main methods:

#### Convert from binary to decimal
```java
  public static int fromBinary(String binaryRaw) {
    if (isInvalidBinary(binaryRaw)) {
      throw new InvalidBinaryProvidedException("Invalid binary provided to convert");
    }
    
    return Integer.parseInt(binaryRaw, BASE_OF_BINARY_NUMBERS);
  }
```

#### Convert from decimal to Binary
```java
  public static String fromDecimal(int randomNumber) {
    if (isNegativeNumber(randomNumber)) {
      throw new InvalidDecimalProvidedException("Invalid decimal provided to convert");
    }
    
    return Integer.toBinaryString(randomNumber);
  }
```

These are simple methods, as well them signatures shows it only does the conversion from binary to decimal and from decimal to binary. However, I used the Test Driven Development (TDD) methodology to create this implementation which brought me a new perspective of how solve problems oriented from application behavior in some situations. Really my mind exploded with this simple code! 🤯

This aproach is one of principles mentioned in the Clean Code book and one of the best practices that we should use to create better code as well delivery applications with more maintainability and readability.