package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection;

public class ClassPath {
    private final static String STUDENT_CLASS = "vadim_nedrega.HW4_Generics.Persons.Student.Student";
    private final static String PLAYER_CLASS = "vadim_nedrega.HW13_Reflection.Player";
    private final static String PLAYER_DATA_CLASS = "vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo.PlayerData";

    public static String getStudentClass() {
        return STUDENT_CLASS;
    }

    public static String getPlayerClass() {
        return PLAYER_CLASS;
    }

    public static String getPlayerDataClass() {
        return PLAYER_DATA_CLASS;
    }
}
