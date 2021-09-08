package vadim_nedrega.HW3.ElementaryCalc.Exceptions;

public class OperatorException extends CalcExceptions {
    private String operationName;
    private String expression;

    public OperatorException() {
        System.out.println("Operator error");
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public OperatorException(String operationName, String expression) {
        this.operationName = operationName;
        this.expression = expression;
    }

    public OperatorException(String message, String operationName, String expression) {
        super(message);
        this.operationName = operationName;
        this.expression = expression;
    }

    public OperatorException(String message, Throwable cause, String operationName, String expression) {
        super(message, cause);
        this.operationName = operationName;
        this.expression = expression;
    }

    public OperatorException(Throwable cause, String operationName, String expression) {
        super(cause);
        this.operationName = operationName;
        this.expression = expression;
    }
}
