public class InterpreterTest {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();

        // 1. Sum
        System.out.println("1. Sum of First N Numbers:");
        String sumProgram = """
            n := 10
            sum := 0
            for i := 1; i <= n; i++ {
                sum += i
            }
            Println(sum)
        """;
        interpreter.eval(sumProgram);
//
//        // 2. Factorial
        System.out.println("\n2. Factorial:");
        String factorialProgram = """
            n := 5
            result := 1
            for i := 1; i <= n; i++ {
                result *= i
            }
            Println(result)
        """;
        interpreter.eval(factorialProgram);
//
//        // 3. GCD
        System.out.println("\n3. GCD:");
        String gcdProgram = """
            a := 48
            b := 18
            for i := 1; b > 0; i++ {
                temp := a % b
                a := b
                b := temp
            }
            Println(a)
        """;
        interpreter.eval(gcdProgram);
//
//        // 4. Reverse Number
        System.out.println("\n4. Reverse Number (1234 should become 4321):");
        String reverseProgram = """
            num := 1234
            reversed := 0
            for i := 0; num != 0; i++ {
                digit := num % 10
                reversed := reversed * 10
                reversed := reversed + digit
                num := num / 10
            }
            Println(reversed)
        """;
        interpreter.eval(reverseProgram);

        // 5. Prime Check (22 should output 0 as it is not prime):  break within if and outside if works, within for loop you can have empty lines and within for loop multiple ifs.
        System.out.println("\n5. Check if a Number is Prime (if it is program should return 1, otherwise 0):");
        String primeCheckProgram = """
    n := 7
    isPrime := 1
    if n <= 1 {
        isPrime = 0
    }
   
    for i := 2; i * i <= n; i++ {
        if n % i ==0 {
        isPrime=0
        break
          }
     }
    Println(isPrime)
""";
        interpreter.eval(primeCheckProgram);
//
//        // 6. Palindrome Check
        System.out.println("\n6. Palindrome Check (121 should output 1 as it is palindrome):");
        String palindromeProgram = """
            num := 121
            temp := num
            reversed := 0
            for i := 0; temp != 0; i++ {
                digit := temp % 10
                reversed := reversed * 10
                reversed := reversed + digit
                temp := temp / 10
            }
            result := 0
            if reversed == num {
                result := 1
            }
            Println(result)
        """;
        interpreter.eval(palindromeProgram);
//
//        // 7. Largest Digit
        System.out.println("\n7. Largest Digit (3947 should output 9):");
        String largestDigitProgram = """
            n := 3947
            maxDigit := 0
            d1 := n % 10
            if d1 > maxDigit {
                maxDigit := d1
            }
            n := n / 10
            d2 := n % 10
            if d2 > maxDigit {
                maxDigit := d2
            }
            n := n / 10
            d3 := n % 10
            if d3 > maxDigit {
                maxDigit := d3
            }
            n := n / 10
            d4 := n % 10
            if d4 > maxDigit {
                maxDigit := d4
            }
            Println(maxDigit)
        """;
        interpreter.eval(largestDigitProgram);
//
//        // 8. Sum of Digits
        System.out.println("\n8. Sum of Digits:");
        String digitSumProgram = """
            num := 1234
            sum := 0
            for i := 1; num > 0; i++ {
                digit := num % 10
                sum += digit
                num := num / 10
            }
            Println(sum)
        """;
        interpreter.eval(digitSumProgram);
//
//        // 9. Multiplication Table
        System.out.println("\n9. Multiplication Table:");
        String multiplicationProgram = """
            n := 5
            for i := 1; i <= 10; i++ {
                result := n * i
                Println(result)
            }
        """;
        interpreter.eval(multiplicationProgram);
//
//        // 10. Fibonacci
        System.out.println("\n10. Fibonacci:");
        String fibonacciProgram = """
            n := 10
            a := 0
            b := 1
            for i := 2; i <= n; i++ {
                c := a + b
                a := b
                b := c
            }
            result := a
            Println(result)
        """;
        interpreter.eval(fibonacciProgram);
    }
}
