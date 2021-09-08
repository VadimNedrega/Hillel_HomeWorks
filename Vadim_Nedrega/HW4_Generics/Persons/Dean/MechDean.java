package vadim_nedrega.HW4_Generics.Persons.Dean;
import vadim_nedrega.HW4_Generics.Persons.Lector.MechLector;
import vadim_nedrega.HW4_Generics.Persons.Staff;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;
import vadim_nedrega.HW4_Generics.Persons.UniversityStaff;

public class MechDean extends Staff implements UniversityStaff<MechLector> {
    String name = "Декан Механизмыч";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void teach(Student student){
        System.out.println(name + " :Вот так можно накрутить правую резьбу левым метчиком...");
    }


    @Override
    public void teach(MechLector mechLector) {
        System.out.println("Смотри как надо держать шуруповерт!");
    }
}
