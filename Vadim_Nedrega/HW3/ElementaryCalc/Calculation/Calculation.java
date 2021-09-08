package vadim_nedrega.HW3.ElementaryCalc.Calculation;

import vadim_nedrega.HW3.ElementaryCalc.Calculator.Display;
import vadim_nedrega.HW3.ElementaryCalc.Exceptions.CalcExceptions;
import vadim_nedrega.HW3.ElementaryCalc.Operand.Operand;
import vadim_nedrega.HW3.ElementaryCalc.Operator.FindOperator;

public class Calculation extends Display {
    private final String operator = new FindOperator().getOperator();
    private final double operand1 = new Operand().getOperand1();
    private final double operand2 = new Operand().getOperand2();
    private double result;

    public Calculation() throws CalcExceptions {
    }

    public double getCalculation() {
        switch (operator) {
            case "+" -> result = operand1 + operand2;
            case "-" -> result = operand1 - operand2;
            case "/" -> result = operand1 / operand2;
            case "*" -> result = operand1 * operand2;
        }
        return result;
    }
}
