package vadim_nedrega.HW9_MVC.View;

import vadim_nedrega.HW9_MVC.Observer.ObserverHW9;

public class ParameterView implements ObserverHW9 {
    @Override
    public void viewTemperatureParameters(String nameOfKiln, int temperatureOfCrossOveChannel, int temperatureInBurningZone,
                                          int temperatureOfExhaustedGas, int temperatureOfLime) {
        System.out.println("Известково-обжигательная печь: " + nameOfKiln);
        System.out.println("Температура в переходном канале: " + temperatureOfCrossOveChannel + " , градусов Цельсия");
        System.out.println("Температура в зоне обжига: " + temperatureInBurningZone + " , градусов Цельсия");
        System.out.println("Температура отходящих газов: " + temperatureOfExhaustedGas + " , градусов Цельсия");
        System.out.println("Температура извести на выгрузочных столах: " + temperatureOfLime + " , градусов Цельсия");
        System.out.println();
    }

    @Override
    public void viewPressureParameters(String nameOfKiln, int pressureOfCrossoverChannel, int pressureOfMainTube,
                                       int pressureOfCollingLancesTube, int pressureOfLimeCoolingTube) {
        System.out.println("Известково-обжигательная печь: " + nameOfKiln);
        System.out.println("Давление в переходном канале: " + pressureOfCrossoverChannel + " , mBar");
        System.out.println("Давление в главной трубе: " + pressureOfMainTube + " , mBar");
        System.out.println("Давление в трубе охлаждения горелок: " + pressureOfCollingLancesTube + " , mBar");
        System.out.println("Давление в трубе охлаждения извести: " + pressureOfLimeCoolingTube + " , mBar");
        System.out.println();
    }
}
