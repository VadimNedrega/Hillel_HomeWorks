package vadim_nedrega.HW15_Annotations;

import vadim_nedrega.HW15_Annotations.MyAnnotations.*;

@Author({"Programmer_1", "Bandit"})
@Version(1)
@ClassInfo(author = {@Author({"John", "Valera"})}, version = @Version(1))
public class PlayerHW15 {
    private String name;
    @FieldInfo(author = {@Author({"Mark"})})
    private int id;
    @FieldInfo(author = {@Author({"John", "Valera"})},
            usingInfo = "Couldn't be used in future, but not 100% sure")
    private boolean isAddicted;

    public PlayerHW15() {
    }

    public PlayerHW15(String name, int id, boolean isAddicted) {
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

    @MethodInfo(author = {@Author({"Vasia" , "Petia"})}, info = @Deprecated)
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
