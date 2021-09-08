package vadim_nedrega.HW11_Decorator.Objects;

public class Player {
    private final String name;
    private final boolean isWantBooze;

    public Player(String name, boolean isWantBooze) {
        this.name = name;
        this.isWantBooze = isWantBooze;
    }

    public String getName() {
        return name;
    }

    public boolean isWantBooze() {
        return isWantBooze;
    }

    public void play(Player player) {
        System.out.println("Let's play...");
    }
}
