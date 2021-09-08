package vadim_nedrega.HW19_Multithreading.WorkForThreads;

import java.util.concurrent.TimeUnit;

public class GetRandomNumbers implements Work {
    @Override
    public void justDoIt() throws WorkForThreadsExceptions {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Начало работы с классом: " + this.getClass().getSimpleName());
            double a = Math.random() * 10;
            i = (int) a;
            System.out.println("Случайное число от 1 до 9: " + i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new WorkForThreadsExceptions("Interrupted");
            }
        }
        System.out.println("Окончание работы с классом: " + this.getClass().getSimpleName());
        System.out.println("================================================================");
    }
}
