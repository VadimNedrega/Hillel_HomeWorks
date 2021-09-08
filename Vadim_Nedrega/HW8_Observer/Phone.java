package vadim_nedrega.HW8_Observer;

import java.util.Date;

public class Phone implements Observer {
    private String stopTheKiln;
    private String startTheKiln;
    private Date timeStart = new Date();
    private Date timeStop = new Date();
    private String stopCause;


    @Override
    public void updateInfoStopKiln(String stopTheKiln, Date timeStop, String stopCause) {
        this.stopTheKiln = stopTheKiln;
        this.timeStop = timeStop;
        this.stopCause = stopCause;
        sentMassageAboutStop();
    }

    @Override
    public void updateInfoStartKiln(String startTheKiln, Date timeStart) {
        this.startTheKiln = startTheKiln;
        this.timeStart = timeStart;
        sentMassageAboutStart();
    }

    public void sentMassageAboutStop() {
        System.out.println(stopTheKiln + timeStop + stopCause);
    }

    public void sentMassageAboutStart() {
        System.out.println(startTheKiln + timeStart);
    }
}
