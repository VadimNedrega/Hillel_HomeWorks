package vadim_nedrega.HW18_Serialization.Objects;

import java.io.Serializable;
import java.util.Objects;

public class FootballManager extends SportManager implements Serializable {
    private static final long serialVersionUID = 16185451351355135L;
    private final Nationality nationality;
    private final FootballPlayer footballPlayer;
    private transient final String agent;

    public FootballManager(String name, int age, String club, Nationality nationality, FootballPlayer footballPlayer, String agent) {
        super(name, age, club);
        this.nationality = nationality;
        this.footballPlayer = footballPlayer;
        this.agent = agent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "nationality=" + nationality +
                "Тренирует игрока: " + footballPlayer +
                ", agent='" + agent + '\'' +
                "} ";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), footballPlayer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FootballManager)) return false;
        if (!super.equals(obj)) return false;
        FootballManager footballManager = (FootballManager) obj;
        return Objects.equals(footballPlayer, footballManager.footballPlayer);
    }
}
