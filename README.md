# Bin2Dec
This project it's a simple binary converter, in the main class BinaryConverter we have two main methods:

#### Convert from binary to decimal
```java
  public static int fromBinary(String binary) {
    if (isInvalidBinary(binary)) {
      throw new InvalidBinaryProvidedException("Invalid binary provided to convert");
    }
    
    return Integer.parseInt(binary, BASE_OF_BINARY_NUMBERS);
  }
```

#### Convert from decimal to binary
```java
  public static String fromDecimal(int decimal) {
    if (isNegativeNumber(decimal)) {
      throw new InvalidDecimalProvidedException("Invalid decimal provided to convert");
    }
    
    return Integer.toBinaryString(decimal);
  }
```

These are simple methods, as well them signatures shows it only does the conversion from binary to decimal and from decimal to binary. However, I used the Test Driven Development (TDD) methodology to create this implementation which brought me a new perspective of how solve problems oriented from application behavior. Really my mind exploded with this simple code! 🤯

All the tests created I left into the test folder, there you can see some situations which I could verify if the application behavior it's happen like I hope.

This aproach is one of principles mentioned in the Clean Code book and one of the best practices that we should use to create better code as well delivery applications with more maintainability and readability.

I hope that this repo could inspire you to write tests into your code right now.

Have a good code ;)
