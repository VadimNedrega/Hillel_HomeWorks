package vadim_nedrega.HW3.ElementaryCalc.Calculator;

public class Display implements Calculator{
    private static String expression;

    public void setExpression(String expression) {
        Display.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String inputData(String expression) {
        setExpression(expression);
        return expression;
    }

}
