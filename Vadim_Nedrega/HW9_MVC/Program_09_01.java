package vadim_nedrega.HW9_MVC;

import vadim_nedrega.HW9_MVC.KilnController.KilnController;
import vadim_nedrega.HW9_MVC.Model.ParametersOfPressure;
import vadim_nedrega.HW9_MVC.Model.ParametersOfTemperature;
import vadim_nedrega.HW9_MVC.View.ParameterView;

public class Program_09_01 {
    public static void main(String[] args) {

        ParametersOfPressure parametersOfPressure = addDefaultPressure();
        ParametersOfTemperature parametersOfTemperature = addDefaultTemps();

        ParameterView parameterView = new ParameterView();

        KilnController kilnController = new KilnController(parametersOfTemperature, parametersOfPressure,
                parameterView);

        parametersOfTemperature.addObserver(parameterView);
        parametersOfPressure.addObserver(parameterView);

        parametersOfTemperature.notifyObserversAboutTemperature();  //до изменений контроллером
        parametersOfPressure.notifyObserversAboutPressure();    //до изменений контроллером

        kilnController.setTemperatureOfCrossOveChannel(1300);
        parametersOfTemperature.notifyObserversAboutTemperature(); //после изменений контроллером

        kilnController.setPressureOfMainTube(900);
        parametersOfPressure.notifyObserversAboutPressure();  //после изменений контроллером

    }

    private static ParametersOfTemperature addDefaultTemps() {
        ParametersOfTemperature parametersOfTemperature = new ParametersOfTemperature();
        parametersOfTemperature.setTemperatureOfCrossOveChannel(1100);
        parametersOfTemperature.setTemperatureInBurningZone(700);
        parametersOfTemperature.setTemperatureOfExhaustedGas(94);
        parametersOfTemperature.setTemperatureOfLime(76);
        return parametersOfTemperature;
    }

    private static ParametersOfPressure addDefaultPressure() {
        ParametersOfPressure pressure = new ParametersOfPressure();
        pressure.setPressureOfCrossoverChannel(111);
        pressure.setPressureOfMainTube(231);
        pressure.setPressureOfLimeCoolingTube(153);
        pressure.setPressureOfCollingLancesTube(312);
        return pressure;
    }

}
