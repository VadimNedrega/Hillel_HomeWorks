package vadim_nedrega.HW17_XML.XMLDataStore;

public class Player {
    private String name;
    private int age;
    private boolean isAddicted;

    public Player() {
    }

    public Player(String name, int age, boolean isAddicted) {
        this.name = name;
        this.age = age;
        this.isAddicted = isAddicted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddicted(boolean addicted) {
        isAddicted = addicted;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAddicted() {
        return isAddicted;
    }

    @Override
    public String toString() {
        return "Игрок: " + name + " " +
                "Возраст: " + age + " " +
                "Азартная зависимость: " + isAddicted;
    }
}
