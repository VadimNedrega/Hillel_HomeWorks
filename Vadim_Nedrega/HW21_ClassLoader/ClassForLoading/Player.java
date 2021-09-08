package vadim_nedrega.HW21_ClassLoader.ClassForLoading;

public class Player {
    private String name;
    private int id;
    private boolean isAddicted;

    public Player() {
    }

    public Player(String name, int id, boolean isAddicted) {
        this.name = name;
        this.id = id;
        this.isAddicted = isAddicted;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAddicted() {
        return this.isAddicted;
    }

    public void setAddicted(boolean addicted) {
        this.isAddicted = addicted;
    }

    @Override
    public String toString() {
        return getName();
    }
}
