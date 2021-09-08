package vadim_nedrega.HW3.ElementaryCalc.Calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetListOfValuesFromDisplay extends Display{

    final Pattern pattern = Pattern.compile("([0-9]+)|(\\+|\\-|\\*|\\/)");


    public ArrayList<String> getList(String expression) {
        Matcher matcher = pattern.matcher(getExpression());
        ArrayList<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
