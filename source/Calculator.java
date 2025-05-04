import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator
{
    private long num1 = 0;
    private long num2 = 0;
    private long result = 0;
    private int numberSystem = 10;

    public int getNumberSystem()
    {
        return numberSystem;
    }

    public long getNum1()
    {
        return num1;
    }

    public long getNum2()
    {
        return num2;
    }

    public long getResult()
    {
        return result;
    }

    public void setNum1(Scanner scanner, String input)
    {
        while(true) {
            try {
                num1 = Long.parseLong(input, numberSystem);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверное корректное число для текущей системы счисления. Напишите новое число.");
                input = scanner.nextLine().trim();
            }
        }
    }

    public void setNum2(Scanner scanner, String input)
    {
        while(true) {
            try {
                num2 = Long.parseLong(input, numberSystem);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверное корректное число для текущей системы счисления. Напишите новое число.");
                input = scanner.nextLine().trim();
            }
        }
    }

    public void setNumberSystem(String systemInput)
    {
        switch (systemInput)
        {
            case "1": numberSystem = 10; break;
            case "2": numberSystem = 16; break;
            case "3": numberSystem = 8; break;
            case "4": numberSystem = 2; break;
            default: System.out.println("Ошибка: неизвестная система счисления.");
        }
    }

    public void performOperation(Operation operation)
    {

        try
        {
            operation.execute();
            result = operation.getResult();
            num1 = result; // Если мы продолжим выполнять операции с текущим найденным числом
        }
        catch (ArithmeticException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String allSystem(long number)
    {
        return "DEC: " + number +
                ", HEX: " + Long.toHexString(number) +
                ", OCT: " + Long.toOctalString(number) +
                ", BIN: " + Long.toBinaryString(number);
    }

    public String getResultInCurrentSystem() {
        switch (numberSystem) {
            case 10:
                return Long.toString(result);
            case 16:
                return Long.toHexString(result);
            case 8:
                return Long.toOctalString(result);
            case 2:
                return Long.toBinaryString(result);
            default:
                return Long.toString(result);
        }
    }

    public static void Operation(Calculator calculator, Scanner scanner) {
        System.out.print("Операции, с которыми работает калькулятор: ");
        System.out.println("\n1) +");
        System.out.println("2) -");
        System.out.println("3) *");
        System.out.println("4) /");
        System.out.print("Введите операцию: ");
        String operationInput = scanner.nextLine().trim();

        switch (operationInput) {
            case "1":
                calculator.performOperation(new Addition(calculator.getNum1(), calculator.getNum2()));
                break;
            case "2":
                calculator.performOperation(new Subtraction(calculator.getNum1(), calculator.getNum2()));
                break;
            case "3":
                calculator.performOperation(new Multiplication(calculator.getNum1(), calculator.getNum2()));
                break;
            case "4":
                calculator.performOperation(new Division(calculator.getNum1(), calculator.getNum2()));
                break;
            default:
                System.out.println("Ошибка: выбран неверный код операции");
        }
    }
}
