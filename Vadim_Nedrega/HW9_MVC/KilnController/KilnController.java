package vadim_nedrega.HW9_MVC.KilnController;

import vadim_nedrega.HW9_MVC.Model.Alarm;
import vadim_nedrega.HW9_MVC.Model.ParametersOfPressure;
import vadim_nedrega.HW9_MVC.Model.ParametersOfTemperature;
import vadim_nedrega.HW9_MVC.Model.ParametersOfTheKiln;
import vadim_nedrega.HW9_MVC.View.ParameterView;

public class KilnController {
    private final ParametersOfTemperature model;
    private final ParametersOfPressure model1;
    private final ParameterView view;
    private ParametersOfTheKiln parametersOfTheKiln = new ParametersOfTheKiln();

    public KilnController(ParametersOfTemperature model, ParametersOfPressure model1, ParameterView view) {
        this.model = model;
        this.model1 = model1;
        this.view = view;
    }

    public int getTemperatureOfCrossOveChannel() {
        return model.getTemperatureOfCrossOveChannel();
    }

    public void setTemperatureOfCrossOveChannel(int temperatureOfCrossOveChannel) {
        if (temperatureOfCrossOveChannel > Alarm.LIMIT_TEMPERATURE_OF_CROSS_OVER_CHANNEL) {
            System.err.println("Тревога!!! Температура в канале максимум");
        }
        model.setTemperatureOfCrossOveChannel(temperatureOfCrossOveChannel);
    }

    public int getTemperatureInBurningZone() {
        return model.getTemperatureOfCrossOveChannel();
    }

    public void setTemperatureInBurningZone(int temperatureInBurningZone) {
        if (temperatureInBurningZone > Alarm.LIMIT_TEMPERATURE_IN_BURNING_ZONE) {
            System.err.println("Тревога!!! Высокая температура в зоне обжига");
        }
        model.setTemperatureInBurningZone(temperatureInBurningZone);
    }

    public int getTemperatureOfExhaustedGas() {
        return model.getTemperatureInBurningZone();
    }

    public void setTemperatureOfExhaustedGas(int temperatureOfExhaustedGas) {
        if (temperatureOfExhaustedGas > Alarm.LIMIT_TEMPERATURE_OF_EXHAUSTED_GAS) {
            System.err.println("Тревога!!! Высокая температура отходящих газов");
        }
        model.setTemperatureOfExhaustedGas(temperatureOfExhaustedGas);
    }

    public int getTemperatureOfLime() {
        return model.getTemperatureOfLime();
    }

    public void setTemperatureOfLime(int temperatureOfLime) {
        if (temperatureOfLime > Alarm.LIMIT_TEMPERATURE_OF_LIME) {
            System.err.println("ААААА!!! Высокая температура извести! Добавьте обороты на воздуходувке охлаждения, " +
                    "а то конвейер нахрен сгорит!!");
        }
        model.setTemperatureOfLime(temperatureOfLime);
    }


    public int getPressureOfCrossoverChannel() {
        return model1.getPressureOfCrossoverChannel();
    }

    public void setPressureOfCrossoverChannel(int pressureOfCrossoverChannel) {
        if (pressureOfCrossoverChannel > Alarm.LIMIT_PRESSURE_OF_CROSSOVER_CHANNEL) {
            System.err.println("ААААА!!! Еще чуть-чуть и печь взорвется!");
        }
        model1.setPressureOfCrossoverChannel(pressureOfCrossoverChannel);
    }

    public int getPressureOfMainTube() {
        return model1.getPressureOfMainTube();
    }

    public void setPressureOfMainTube(int pressureOfMainTube) {
        if (pressureOfMainTube > Alarm.LIMIT_PRESSURE_OF_MAIN_TUBE) {
            System.err.println("ААААА!!! Ну всё, капец трубе!");
        }
        model1.setPressureOfMainTube(pressureOfMainTube);
    }

    public int getPressureOfCollingLancesTube() {
        return model1.getPressureOfCollingLancesTube();
    }

    public void setPressureOfCollingLancesTube(int pressureOfCollingLancesTube) {
        if (pressureOfCollingLancesTube > Alarm.LIMIT_PRESSURE_OF_COLLING_LANCES_TUBE) {
            System.err.println("Ээээххх, хорошие были горелки...");
        }
        model1.setPressureOfCollingLancesTube(pressureOfCollingLancesTube);
    }

    public int getPressureOfLimeCoolingTube() {
        return model1.getPressureOfLimeCoolingTube();
    }

    public void setPressureOfLimeCoolingTube(int pressureOfLimeCoolingTube) {
        if (pressureOfLimeCoolingTube > Alarm.LIMIT_PRESSURE_OF_LIME_COOLING_TUBE) {
            System.err.println("Хватит морозить известь, труба не выдержит!!!");
        }
        model1.setPressureOfLimeCoolingTube(pressureOfLimeCoolingTube);
    }

}
