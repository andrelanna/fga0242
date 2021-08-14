package exceptions;

public class LimiteSuperiorExtrapoladoException extends Exception
{
    public LimiteSuperiorExtrapoladoException()
    {
        super("Limite superior extrapolado.");
    }
}
