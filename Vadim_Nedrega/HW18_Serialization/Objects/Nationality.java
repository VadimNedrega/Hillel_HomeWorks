package vadim_nedrega.HW18_Serialization.Objects;

public enum Nationality {
    England("England"),
    Ukrainian("Ukrainian"),
    Ethiopian("Ethiopian"),
    German("German");

    private final String description;

    Nationality(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
