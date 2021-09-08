package vadim_nedrega.HW16_3Patterns.FactoryMethod.Player;

public class FootballPlayer extends Player {
    @Override
    public void play() {
        System.out.println("Ща гол забью");
    }

    public FootballPlayer(String name, boolean sex, int age) {
        super(name, sex, age);
    }

}
