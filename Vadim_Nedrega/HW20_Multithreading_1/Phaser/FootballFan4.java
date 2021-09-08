package vadim_nedrega.HW20_Multithreading_1.Phaser;

import java.util.concurrent.Phaser;

public class FootballFan4 implements Runnable {
    private String fanName;
    private int fanId;
    public Phaser phaser;

    public FootballFan4() {
    }

    public FootballFan4(Phaser phaser, String name) {
        this.phaser = phaser;
        this.fanName = name;
        phaser.register();
    }

    public String getFanName() {
        return fanName;
    }

    public void setFanName(String fanName) {
        fanName = fanName;
    }

    public int getFanId() {
        return fanId;
    }

    public void setFanId(int fanId) {
        this.fanId = fanId;
    }

    @Override
    public void run() {
        System.out.println( fanName + " покупает билет под номером " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println( fanName + " покупает билет под номером " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println( fanName + " покупает билет под номером " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }



}
