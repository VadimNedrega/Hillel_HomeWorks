import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumFormatTranslatorTestLog4jLogging {
    private static final Logger LOG_4J = Logger.getLogger(NumFormatTranslatorTestLog4jLogging.class);

    @Mock
    private NumFormatTranslator testInstance;

    @Test
    void checkIfEmpty() {
        LOG_4J.info("Test has started");
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse(""));
    }

    @Test
    void checkIfNull() {
        LOG_4J.debug("Debugging something");
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse(null));
    }

    @Test
    public void invalidDataSmallString() {
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse("1"));
    }

    @Test
    public void invalidDataBigString() {
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse("654654564554564564564"));
    }

    @Test
    void same() throws ParseException {
        testInstance = new NumFormatTranslator();
        assertEquals(testInstance.parse("+646"), 646);
    }

}