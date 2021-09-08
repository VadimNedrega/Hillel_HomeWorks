package vadim_nedrega.HW3.ElementaryCalc.PrintResult;

import vadim_nedrega.HW3.ElementaryCalc.Calculation.Calculation;
import vadim_nedrega.HW3.ElementaryCalc.Exceptions.CalcExceptions;

public class PrintResult extends Calculation {


    public PrintResult() throws CalcExceptions {
    }

    public void printResult() throws CalcExceptions {
        System.out.println(getCalculation());
    }
}
