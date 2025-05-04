public class Division extends Operation
{
    public Division(long num1, long num2)
    {
        super(num1, num2);
    }

    @Override
    public void execute()
    {
        if (num2 == 0)
        {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        result = num1 / num2;
    }
}
