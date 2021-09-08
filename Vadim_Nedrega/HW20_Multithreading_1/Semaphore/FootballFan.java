package vadim_nedrega.HW20_Multithreading_1.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FootballFan extends Thread {
    private String fanName;
    private int fanId;
    public Semaphore cashbox;

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
        System.out.println(this.fanName + " ожидает свободную кассу");
        try {
            cashbox.acquire();
            System.out.println(this.fanName + " покупает билет");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(this.fanName + " освобождает кассу");
            cashbox.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
