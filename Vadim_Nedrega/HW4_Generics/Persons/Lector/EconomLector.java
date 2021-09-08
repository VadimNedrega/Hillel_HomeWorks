package vadim_nedrega.HW4_Generics.Persons.Lector;

import vadim_nedrega.HW4_Generics.Persons.Staff;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;
import vadim_nedrega.HW4_Generics.Persons.UniversityStaff;

public class EconomLector extends Staff implements UniversityStaff<Student> {
    String name = "Лектор Эконом Потапыч";
    public void teach(Student student){
    }

    public void letsEconom(){
        System.out.println(name + " :Буду учить вас экономить!");
    }
}
