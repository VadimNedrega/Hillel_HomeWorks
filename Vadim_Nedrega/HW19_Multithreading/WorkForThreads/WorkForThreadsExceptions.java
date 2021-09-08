package vadim_nedrega.HW19_Multithreading.WorkForThreads;

import java.io.IOException;

public class WorkForThreadsExceptions extends IOException {
    public WorkForThreadsExceptions() {
        super();
    }

    public WorkForThreadsExceptions(String message) {
        super(message);
    }

    public WorkForThreadsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkForThreadsExceptions(Throwable cause) {
        super(cause);
    }
}
