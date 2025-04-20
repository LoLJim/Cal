public class Subtraction extends Operation
{
    public Subtraction(long num1, long num2)
    {
        super(num1, num2);
    }

    @Override
    public void execute()
    {
        result = num1 - num2;
    }

    @Override
    public String getOperationSymbol()
    {
        return "-";
    }
}
