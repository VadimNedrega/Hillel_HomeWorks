package vadim_nedrega.HW20_Multithreading_1.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FootballFan2 implements Runnable {
    private String fanName;
    private int fanId;
    public CyclicBarrier cyclicBarrier;

    public FootballFan2() {
    }

    public FootballFan2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        new Thread(this).start();
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
        System.out.println(this.fanName + " билет куплен");
        try {
            cyclicBarrier.await();
            Thread.sleep(3000);
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println("Barrier error");
        }
    }


}
