package vadim_nedrega.HW3.ElementaryCalc;
import vadim_nedrega.HW3.ElementaryCalc.Calculator.Display;
import vadim_nedrega.HW3.ElementaryCalc.Exceptions.CalcExceptions;
import vadim_nedrega.HW3.ElementaryCalc.PrintResult.PrintResult;

public class ProgramHW3_01 {
    public static void main(String[] args) throws CalcExceptions {
        Display display = new Display();
        display.inputData("65/89");
        PrintResult printResult = new PrintResult();
        printResult.printResult();
    }
}
