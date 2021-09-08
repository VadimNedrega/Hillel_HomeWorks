package vadim_nedrega.HW16_3Patterns.Adapter.Composition;

import vadim_nedrega.HW16_3Patterns.Adapter.Inheritance.Cat;
import vadim_nedrega.HW16_3Patterns.Adapter.Inheritance.TV;

public class CatAdapter1 implements Cat {
    private final TV1 tv1 = new TV1();


    @Override
    public String eat() {
        return tv1.getMute();
    }

    @Override
    public String move() {
        return tv1.getTurnOn();
    }

    @Override
    public String sleep() {
        return tv1.getTurnOff();
    }
}
