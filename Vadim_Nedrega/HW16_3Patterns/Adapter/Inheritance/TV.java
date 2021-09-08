package vadim_nedrega.HW16_3Patterns.Adapter.Inheritance;

public class TV {
    public String getTurnOn(){
        return "Включен";
    }

    public String getTurnOff(){
        return "Выключен";
    }

    public String getMute(){
        return "Звук выключен";
    }
}
