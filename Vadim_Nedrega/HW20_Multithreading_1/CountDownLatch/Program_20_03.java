package vadim_nedrega.HW20_Multithreading_1.CountDownLatch;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Program_20_03 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 10; i++) {
            FootballFan1 fan = new FootballFan1(countDownLatch);
            fan.setFanName("Fan_" + i);
            fan.setFanId(i);
            fan.start();
        }

        try {
            countDownLatch.await();
            System.out.println("Первые 5 болельщиков купили билеты".toUpperCase(Locale.ROOT));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
