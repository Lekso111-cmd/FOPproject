# Interpreter Project

## Project Description

This project implements a simple interpreter for a custom scripting language. The interpreter supports variable declarations, assignments, arithmetic operations, conditional statements, loops, and printing output. The purpose of this project is to practice programming concepts such as encapsulation, inheritance, and generics, as well as enhance teamwork skills.

## Team Members and Roles

1. **Baka Chanturia**   Role: Core interpreter functionality implementation

2. **Lekso Potskhverashvili**   Role: Testing and additional feature development

3. **Avtandil Ananidze**   Role: Loops and conditional structures

4. **Giorgi Davlianidze**   Role: Expression evaluation and condition handling

## Setting Up the Project

### Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK) 8 or later
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code)

### Steps to Set Up

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd <project-directory>
   ```
3. Open the project in your preferred Java IDE.
4. Compile the Java files:
   ```bash
   javac *.java
   ```

### Running the Project

1. Run the `InterpreterTest` class to execute the sample programs and tests:
   ```bash
   java InterpreterTest
   ```
2. To test with your custom scripts, modify the `InterpreterTest` class with new input scripts.

## Inline Documentation

Each feature or module in the project includes detailed inline comments to explain the logic and purpose of the code. Please refer to the source files for more details on the implementation.

## Example Usage

Here is an example script supported by the interpreter:

```java
n := 10
sum := 0
for i := 1; i <= n; i++ {
    sum += i
}
Println(sum)
```

This program calculates the sum of integers from 1 to 10 and prints the result.
