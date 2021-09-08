package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo;

import java.io.IOException;

public class DataInfoExceptions extends IOException {
    public DataInfoExceptions() {
    }

    public DataInfoExceptions(String message) {
        super(message);
    }

    public DataInfoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DataInfoExceptions(Throwable cause) {
        super(cause);
    }
}
