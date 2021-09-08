package vadim_nedrega.HW18_Serialization.Objects;

import java.io.Serializable;
import java.util.Objects;

public class SportManager implements Serializable {
    private static final long serialVersionUID = 618545135135135L;
    private final String name;
    private final int age;
    private final transient String club;

    public SportManager(String name, int age, String club) {
        this.name = name;
        this.age = age;
        this.club = club;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", club='" + club + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SportManager)) return false;
        SportManager sportManager = (SportManager) obj;
        return name.equals(sportManager.name) && age == sportManager.age;
    }
}
