package vadim_nedrega.HW3.ElementaryCalc.Operand;

import vadim_nedrega.HW3.ElementaryCalc.Calculator.Display;
import vadim_nedrega.HW3.ElementaryCalc.Calculator.GetListOfValuesFromDisplay;
import vadim_nedrega.HW3.ElementaryCalc.Exceptions.OperandException;

import java.util.ArrayList;

public class Operand {
    Display display = new Display();

    public double getOperand1() throws OperandException {
        ArrayList<String> list = new GetListOfValuesFromDisplay().getList(display.getExpression());
        try {
            return Double.parseDouble(list.get(0));
        } catch (NumberFormatException e) {
           e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            throw new OperandException();
        }
        return Double.parseDouble(list.get(0));
    }

    public double getOperand2() throws OperandException {
        ArrayList<String> list = new GetListOfValuesFromDisplay().getList(display.getExpression());
        try {
            return Double.parseDouble(list.get(2));
        } catch (NumberFormatException e) {
           e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            throw new OperandException();
        }
        return Double.parseDouble(list.get(2));
    }
}
