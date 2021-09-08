package vadim_nedrega.HW3.ElementaryCalc.Operator;

import vadim_nedrega.HW3.ElementaryCalc.Calculator.Display;
import vadim_nedrega.HW3.ElementaryCalc.Calculator.GetListOfValuesFromDisplay;
import vadim_nedrega.HW3.ElementaryCalc.Exceptions.OperatorException;

import java.util.ArrayList;

public class FindOperator implements Operator{
    public static String operator;
    Display display = new Display();
    ArrayList<String> list = new GetListOfValuesFromDisplay().getList(display.getExpression());

    @Override
    public String getOperator() {
        try {
            operator = list.get(1);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return operator;
    }
}
