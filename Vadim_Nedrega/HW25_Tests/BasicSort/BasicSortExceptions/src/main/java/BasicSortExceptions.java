import java.io.IOException;

public class BasicSortExceptions extends IOException {
    public BasicSortExceptions() {
        super();
    }

    public BasicSortExceptions(String message) {
        super(message);
    }

    public BasicSortExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public BasicSortExceptions(Throwable cause) {
        super(cause);
    }
}
