package vadim_nedrega.HW18_Serialization.Objects;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FootballPlayer implements Externalizable {
    private static final long serialVersionUID = 2618545135513L;
    private String name;
    private int age;
    private boolean isCapitan;
    private transient String position;

    public FootballPlayer() {
    }

    public FootballPlayer(String name, int age, boolean isCapitan, String position) {
        this.name = name;
        this.age = age;
        this.isCapitan = isCapitan;
        this.position = position;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(name)
                .append("_%")
                .append(age)
                .append("_%")
                .append(isCapitan);
        out.write(builder.toString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        byte[] arr = new byte[in.available()];
        in.read(arr);
        String result = new String(arr, StandardCharsets.UTF_8);
        String[] value = result.split("_%");

        name = value[0];
        age = Integer.parseInt(value[1]);
        isCapitan = Boolean.parseBoolean(value[2]);

    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isCapitan=" + isCapitan +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isCapitan);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FootballPlayer)) return false;
        FootballPlayer footballPlayer = (FootballPlayer) obj;
        return name.equals(footballPlayer.name)
                && age == footballPlayer.age
                && isCapitan == footballPlayer.isCapitan;
    }
}
