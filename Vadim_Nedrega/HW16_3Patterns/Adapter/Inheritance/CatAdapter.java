package vadim_nedrega.HW16_3Patterns.Adapter.Inheritance;

public class CatAdapter extends TV implements Cat{
    @Override
    public String eat() {
        return getMute();
    }

    @Override
    public String move() {
        return getTurnOn();
    }

    @Override
    public String sleep() {
        return getTurnOff();
    }
}
