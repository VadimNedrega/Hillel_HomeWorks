package vadim_nedrega.HW4_Generics.Persons.Dean;

import vadim_nedrega.HW4_Generics.Persons.Lector.EconomLector;
import vadim_nedrega.HW4_Generics.Persons.Staff;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;
import vadim_nedrega.HW4_Generics.Persons.UniversityStaff;

public class EconomicDean extends Staff implements UniversityStaff<EconomLector> {
    String name = "Декан Экономыч";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void teach(Student student){
        System.out.println(name + " :Смотрите как экономит профи!");
    }

    @Override
    public void teach(EconomLector economLector) {
        System.out.println(name + " говорит: Из-за тебя мне влепили выговор! Иди и выучи студента!");
    }
}
