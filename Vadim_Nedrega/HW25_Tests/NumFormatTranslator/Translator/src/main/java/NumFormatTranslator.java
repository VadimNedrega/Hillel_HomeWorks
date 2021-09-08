import java.text.ParseException;

public class NumFormatTranslator {

    private final ParseStringToInt PARSE_STRING_TO_INT = new ParseStringToInt();

    public int parse(String str) throws ParseException {
        if (str == null) throw new ParseException("Element is null", 1);

        if (str.equals("")) throw new ParseException("Element is empty", 1);

        if (str.length() < 2 || str.length()>10) throw new ParseException("String can't be parsed", 1);

        return PARSE_STRING_TO_INT.parseInt(str);

    }

}
