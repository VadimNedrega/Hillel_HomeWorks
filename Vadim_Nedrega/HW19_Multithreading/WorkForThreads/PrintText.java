package vadim_nedrega.HW19_Multithreading.WorkForThreads;

import java.util.concurrent.TimeUnit;

public class PrintText implements Work {
    private final String text;

    public PrintText(String text) {
        this.text = text;
    }

    @Override
    public void justDoIt() throws WorkForThreadsExceptions {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Начало работы с классом: " + this.getClass().getSimpleName());
        for (int i = 0; i < 5; i++) {
            System.out.println(text + "_" + i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new WorkForThreadsExceptions(e);
            }
        }
        System.out.println("Окончание работы с классом: " + this.getClass().getSimpleName());
        System.out.println("================================================================");
    }
}
