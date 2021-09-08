package vadim_nedrega.HW9_MVC.Observer;

public interface ObserverHW9 {
    String nameOfKiln = "Cimprogetti 55 Twin-D Reversy";

    void viewTemperatureParameters(String nameOfKiln, int temperatureOfCrossOveChannel, int temperatureInBurningZone,
                                   int temperatureOfExhaustedGas, int temperatureOfLime);

    void viewPressureParameters(String nameOfKiln, int pressureOfCrossoverChannel, int pressureOfMainTube,
                                int pressureOfCollingLancesTube, int pressureOfLimeCoolingTube);
}
