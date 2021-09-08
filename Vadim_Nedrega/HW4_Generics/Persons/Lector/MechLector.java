package vadim_nedrega.HW4_Generics.Persons.Lector;

import vadim_nedrega.HW4_Generics.Persons.Staff;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;
import vadim_nedrega.HW4_Generics.Persons.UniversityStaff;

public class MechLector extends Staff implements UniversityStaff<Student> {
    String name = "Лектор Механизм Иваныч";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void teach(Student student){
    }

    public void doDeadMachine(){
        System.out.println(name + " :А давайте разработаем смертельное оружие");
    }
}
