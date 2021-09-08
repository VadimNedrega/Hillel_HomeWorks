package vadim_nedrega.HW20_Multithreading_1.Exchanger;

public class FootballFan3 extends Thread{
    private String fanName;
    private int fanId;

    public FootballFan3() {
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
}
