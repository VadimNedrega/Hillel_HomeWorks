import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumFormatTranslatorTestJulLogging {
    private static final Logger LOG_JUL = Logger.getLogger(NumFormatTranslatorTestJulLogging.class.getName());
    private final SimpleFormatter formatter = new SimpleFormatter();
    private FileHandler fh;


    @Mock
    private NumFormatTranslator testInstance;

    @Test
    void checkIfEmpty() {
        LOG_JUL.info("Test has started");
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse(""));
    }

    @Test
    void checkIfNull() throws IOException {
        fh = new FileHandler("MyLogFile.log");
        fh.setFormatter(formatter);
        LOG_JUL.addHandler(fh);
        LOG_JUL.log(Level.INFO, "Some info");

        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse(null));
    }

    @Test
    public void invalidDataSmallString() {
        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse("1"));
    }

    @Test
    public void invalidDataBigString() throws IOException {
        fh = new FileHandler("MyLogFile1.log");
        fh.setFormatter(formatter);
        LOG_JUL.addHandler(fh);
        LOG_JUL.log(Level.INFO, "Some info1");

        testInstance = new NumFormatTranslator();
        assertThrows(ParseException.class, () -> testInstance.parse("654654564554564564564"));
    }

    @Test
    void same() throws ParseException {
        testInstance = new NumFormatTranslator();
        assertEquals(testInstance.parse("+646"), 646);
    }

}