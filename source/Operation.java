public abstract class Operation
{
    public long num1;
    public long num2;
    public long result;

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

}

