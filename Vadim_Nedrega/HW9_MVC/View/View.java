package vadim_nedrega.HW9_MVC.View;

import vadim_nedrega.HW9_MVC.Observer.ObserverHW9;

public class View implements ObserverHW9 {

    @Override
    public void viewTemperatureParameters(String nameOfKiln,
                                          int temperatureOfCrossOveChannel,
                                          int temperatureInBurningZone,
                                          int temperatureOfExhaustedGas,
                                          int temperatureOfLime) {

    }

    @Override
    public void viewPressureParameters(String nameOfKiln,
                                       int pressureOfCrossoverChannel,
                                       int pressureOfMainTube,
                                       int pressureOfCollingLancesTube,
                                       int pressureOfLimeCoolingTube) {

    }
}
