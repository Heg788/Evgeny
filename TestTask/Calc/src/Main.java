
import java.util.Scanner;

public class Main {
    static int numberOne = 0;
    static int numberTwo = 0;
    static char operation;
    static int result = 0;
    static int sum;

    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите данные в формате (1+1) или (I+I)");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            char[] tenChar = new char[10];
            for (int i = 0; i < userInput.length(); i++) {
                tenChar[i] = userInput.charAt(i);
                if (tenChar[i] == '+') {
                    operation = '+';
                    sum++;
                }
                if (tenChar[i] == '-') {
                    operation = '-';
                    sum++;
                }
                if (tenChar[i] == '*') {
                    operation = '*';
                    sum++;
                }
                if (tenChar[i] == '/') {
                    operation = '/';
                    sum++;
                }
            }

            userInput = userInput.replaceAll(" ", "").toUpperCase().trim();
            userInput = userInput.replaceAll("[+/*-]", " ");
            String[] numberArray = userInput.split(" ");

            while (true) {
                if (sum > 1) {
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    break;
                }
                if (numberArray[0].matches("[A-Z]") && numberArray[1].matches("\\d")) {
                    System.out.println("Используются одновременно разные системы счисления");
                    break;
                }
                if (numberArray[0].matches("\\d") && numberArray[1].matches("[A-Z]")) {
                    System.out.println("Используются одновременно разные системы счисления");
                    break;
                }

                if (numberArray[0].matches("\\d") && numberArray[1].matches("\\d")) {
                    if (operation == '+') {
                        result = Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
                        System.out.println(result);
                    }
                    if (operation == '-') {
                        result = Integer.parseInt(numberArray[0]) - Integer.parseInt(numberArray[1]);
                        System.out.println(result);
                    }
                    if (operation == '*') {
                        result = Integer.parseInt(numberArray[0]) * Integer.parseInt(numberArray[1]);
                        System.out.println(result);
                    }
                    try {
                        if (operation == '/') {
                            result = Integer.parseInt(numberArray[0]) / Integer.parseInt(numberArray[1]);
                            System.out.println(result);
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка! Деление на 0!");
                    }
                    break;
                }

//-----------------------------------------------------------------------------------------//
                for (int i = 0; i < roman.length; i++) {
                    if (roman[i].matches(numberArray[0])) {
                        numberOne = i;
                    }
                }
                for (int j = 0; j < roman.length; j++) {
                    if (roman[j].matches(numberArray[1])) {
                        numberTwo = j;
                    }
                }
                if (numberArray[0].matches("[A-Z]") && numberArray[1].matches("[A-Z]")) {
                    if (operation == '+') {
                        result = numberOne + numberTwo;
                        System.out.println(roman[result]);
                    }
                    try {
                        if (operation == '-') {
                            result = numberOne - numberTwo;
                            System.out.println(roman[result]);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В римской системе нет отрицательных чисел");
                    }
                    if (operation == '*') {
                        result = numberOne * numberTwo;
                        System.out.println(roman[result]);
                    }
                    try {
                        if (operation == '/') {
                            result = numberOne / numberTwo;
                            System.out.println(roman[result]);
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка! Деление на 0!");
                    }
                    break;
                }
            }
        }
    }
}