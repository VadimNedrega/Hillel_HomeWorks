package vadim_nedrega.HW9_MVC.Model;

import vadim_nedrega.HW9_MVC.Observer.ObserverHW9;
import vadim_nedrega.HW9_MVC.Observer.ObservableHW9_Pressure;

import java.util.ArrayList;

public class ParametersOfPressure extends ParametersOfTheKiln implements ObservableHW9_Pressure {
    private ArrayList<ObserverHW9> observers;
    private int pressureOfCrossoverChannel;
    private int pressureOfMainTube;
    private int pressureOfCollingLancesTube;
    private int pressureOfLimeCoolingTube;

    public ParametersOfPressure(){
        observers = new ArrayList<>();
    }

    public int getPressureOfCrossoverChannel() {
        return pressureOfCrossoverChannel;
    }

    public void setPressureOfCrossoverChannel(int pressureOfCrossoverChannel) {
        this.pressureOfCrossoverChannel = pressureOfCrossoverChannel;
    }

    public int getPressureOfMainTube() {
        return pressureOfMainTube;
    }

    public void setPressureOfMainTube(int pressureOfMainTube) {
        this.pressureOfMainTube = pressureOfMainTube;
    }

    public int getPressureOfCollingLancesTube() {
        return pressureOfCollingLancesTube;
    }

    public void setPressureOfCollingLancesTube(int pressureOfCollingLancesTube) {
        this.pressureOfCollingLancesTube = pressureOfCollingLancesTube;
    }

    public int getPressureOfLimeCoolingTube() {
        return pressureOfLimeCoolingTube;
    }

    public void setPressureOfLimeCoolingTube(int pressureOfLimeCoolingTube) {
        this.pressureOfLimeCoolingTube = pressureOfLimeCoolingTube;
    }


    @Override
    public void addObserver(ObserverHW9 observerHW9) {
        observers.add(observerHW9);
    }

    @Override
    public void removeObserver(ObserverHW9 observerHW9) {
        observers.remove(observerHW9);
    }

    @Override
    public void notifyObserversAboutPressure() {
        for (ObserverHW9 observer : observers) {
            observer.viewPressureParameters(ObserverHW9.nameOfKiln,
                    pressureOfCrossoverChannel,
                    pressureOfMainTube,
                    pressureOfCollingLancesTube,
                    pressureOfLimeCoolingTube);
        }
    }
}
