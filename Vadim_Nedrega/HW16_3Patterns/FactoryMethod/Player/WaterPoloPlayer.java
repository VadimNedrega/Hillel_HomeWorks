package vadim_nedrega.HW16_3Patterns.FactoryMethod.Player;

public class WaterPoloPlayer extends Player {
    @Override
    public void play() {
        System.out.println("Хоть бы не утонуть");
    }

    public WaterPoloPlayer(String name, boolean sex, int age) {
        super(name, sex, age);
    }
}
