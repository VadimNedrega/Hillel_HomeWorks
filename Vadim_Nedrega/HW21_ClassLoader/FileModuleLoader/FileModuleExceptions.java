package vadim_nedrega.HW21_ClassLoader.FileModuleLoader;

import java.io.IOException;

public class FileModuleExceptions extends IOException {
    public FileModuleExceptions() {
        super();
    }

    public FileModuleExceptions(String message) {
        super(message);
    }

    public FileModuleExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public FileModuleExceptions(Throwable cause) {
        super(cause);
    }
}
