package vadim_nedrega.HW8_Observer;

import java.util.ArrayList;
import java.util.Date;

public class Dispatcher implements Observable {
    private ArrayList<Observer> observers;
    private String stopTheKiln;
    private String startTheKiln;
    private Date timeStart = new Date();
    private Date timeStop = new Date();
    private String stopCause;

    public Dispatcher() {
        observers = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserversAboutStopTheKiln() {
        for (Observer observer : observers) {
            observer.updateInfoStopKiln(stopTheKiln, timeStop, stopCause);
        }
    }

    @Override
    public void notifyObserversAboutStartTheKiln() {
        for (Observer observer : observers) {
            observer.updateInfoStartKiln(startTheKiln, timeStart);
        }
    }

    public void setDataStop(String stopTheKiln, Date timeStop, String stopCause) {
        this.stopTheKiln = stopTheKiln;
        this.timeStop = timeStop;
        this.stopCause = stopCause;
        notifyObserversAboutStopTheKiln();
    }

    public void setStartInfo(String startTheKiln, Date timeStart) {
        this.startTheKiln = startTheKiln;
        this.timeStart = timeStart;
        notifyObserversAboutStartTheKiln();
    }
}
