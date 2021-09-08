package vadim_nedrega.HW16_3Patterns.FactoryMethod.Player;

public abstract class Player {
    private String name;
    private boolean sex;
    private int age;

    public abstract void play();

    public Player(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
