package vadim_nedrega.HW3.ElementaryCalc.Exceptions;

public class OperandException extends CalcExceptions {
    public OperandException() {
    }

    public OperandException(String message) {
        super(message);
    }

    public OperandException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperandException(Throwable cause) {
        super(cause);
    }
}
