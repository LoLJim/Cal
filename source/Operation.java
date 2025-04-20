public abstract class Operation
{
    protected long num1;
    protected long num2;
    protected long result;

    public Operation(long num1, long num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract void execute();

    public long getResult()
    {
        return result;
    }

    public abstract String getOperationSymbol();

    public String toString(int numberSystem)
    {
        return formatNumber(num1, numberSystem) + " " + getOperationSymbol() + " " +
                formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem);
    }

    protected static String formatNumber(long number, int numberSystem)
    {
        switch (numberSystem)
        {
            case 2: return Long.toBinaryString(number);
            case 8: return Long.toOctalString(number);
            case 10: return Long.toString(number);
            case 16: return Long.toHexString(number);
            default: throw new IllegalArgumentException("Неподдерживаемая система счисления: " + numberSystem);
        }
    }
}

