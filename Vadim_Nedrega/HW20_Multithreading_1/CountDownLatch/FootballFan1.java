package vadim_nedrega.HW20_Multithreading_1.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class FootballFan1 extends Thread {
    private String fanName;
    private int fanId;
    public CountDownLatch countDownLatch;

    public FootballFan1() {
    }

    public FootballFan1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public String getFanName() {
        return fanName;
    }

    public void setFanName(String fanName) {
        this.fanName = fanName;
    }

    public int getFanId() {
        return fanId;
    }

    public void setFanId(int fanId) {
        this.fanId = fanId;
    }

    @Override
    public void run() {
        System.out.println(this.fanName + " покупает билет");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(this.fanName + " билет куплен");
    }
}
