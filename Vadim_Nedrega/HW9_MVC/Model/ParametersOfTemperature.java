package vadim_nedrega.HW9_MVC.Model;

import vadim_nedrega.HW9_MVC.Observer.ObserverHW9;
import vadim_nedrega.HW9_MVC.Observer.ObservableHW9_Temperature;

import java.util.ArrayList;

public class ParametersOfTemperature extends ParametersOfTheKiln implements ObservableHW9_Temperature {
    private ArrayList<ObserverHW9> observers;
    private int temperatureOfCrossOveChannel;
    private int temperatureInBurningZone;
    private int temperatureOfExhaustedGas;
    private int temperatureOfLime;

    public ParametersOfTemperature(){
        observers = new ArrayList<>();
    }

    public int getTemperatureOfCrossOveChannel() {
        return temperatureOfCrossOveChannel;
    }

    public void setTemperatureOfCrossOveChannel(int temperatureOfCrossOveChannel) {
        this.temperatureOfCrossOveChannel = temperatureOfCrossOveChannel;
    }

    public int getTemperatureInBurningZone() {
        return temperatureInBurningZone;
    }

    public void setTemperatureInBurningZone(int temperatureInBurningZone) {
        this.temperatureInBurningZone = temperatureInBurningZone;
    }

    public int getTemperatureOfExhaustedGas() {
        return temperatureOfExhaustedGas;
    }

    public void setTemperatureOfExhaustedGas(int temperatureOfExhaustedGas) {
        this.temperatureOfExhaustedGas = temperatureOfExhaustedGas;
    }

    public int getTemperatureOfLime() {
        return temperatureOfLime;
    }

    public void setTemperatureOfLime(int temperatureOfLime) {
        this.temperatureOfLime = temperatureOfLime;
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
    public void notifyObserversAboutTemperature() {
        for (ObserverHW9 observer : observers) {
            observer.viewPressureParameters(ObserverHW9.nameOfKiln,
                    temperatureOfCrossOveChannel,
                    temperatureInBurningZone,
                    temperatureOfExhaustedGas,
                    temperatureOfLime);
        }
    }
}
