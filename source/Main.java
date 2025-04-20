import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true)
        {
            System.out.println("\n1) Написать выражение");
            System.out.println("2) Выбрать систему счисления");
            System.out.println("3) Продолжить операции с результатом");
            System.out.println("4) Выход");
            System.out.println("Результат: " + Calculator.allSystem(calculator.getResult()));
            System.out.println("Текущая система счисления:" + calculator.getNumberSystem());
            System.out.print("Введите номер действия: ");

            String input = scanner.nextLine().trim();

            switch (input)
            {
                case "1":
                    System.out.print("Введите первое число: ");
                    calculator.setNum1(scanner.nextLine().trim());
                    System.out.print("Введите второе число: ");
                    calculator.setNum2(scanner.nextLine().trim());
                    calculator.Operation(calculator, scanner);
                    break;
                case "2":
                    System.out.println("Выберите систему счисления:");
                    System.out.println("1) Десятичная (dec)");
                    System.out.println("2) Шестнадцатеричная (hex)");
                    System.out.println("3) Восьмеричная (oct)");
                    System.out.println("4) Двоичная (bin)");
                    System.out.print("Введите номер системы счисления: ");
                    calculator.setNumberSystem(scanner.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Введите второе число: ");
                    calculator.setNum2(scanner.nextLine().trim());
                    calculator.Operation(calculator, scanner);
                    break;
                case "4":
                    System.out.println("Выход из калькулятора.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ошибка: неизвестное действие.");
            }
        }
    }
}
