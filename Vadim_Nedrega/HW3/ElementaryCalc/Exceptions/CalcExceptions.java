package vadim_nedrega.HW3.ElementaryCalc.Exceptions;

public class CalcExceptions extends Exception {
    public CalcExceptions() {
    }

    public CalcExceptions(String message) {
        super(message);
    }

    public CalcExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcExceptions(Throwable cause) {
        super(cause);
    }
}
