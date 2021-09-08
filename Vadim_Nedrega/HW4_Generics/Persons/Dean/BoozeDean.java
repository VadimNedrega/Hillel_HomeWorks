package vadim_nedrega.HW4_Generics.Persons.Dean;
import vadim_nedrega.HW4_Generics.Persons.Lector.BoozeLector;
import vadim_nedrega.HW4_Generics.Persons.Staff;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;
import vadim_nedrega.HW4_Generics.Persons.UniversityStaff;

public class BoozeDean extends Staff implements UniversityStaff<BoozeLector> {
    String name = "Декан Мистер дегустатор";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void teach(BoozeLector boozeLector) {
        System.out.println(name + " Надо бы подучить лектора парочке новых приемов самогоноварения");
    }

    public void teach(Student student) {
        System.out.println(name + " :Учитесь у профи");
    }
}
