package vadim_nedrega.HW4_Generics.Persons.Student;

import vadim_nedrega.HW4_Generics.Human;

public class Student extends Human {
    String student;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }


    public void doEconomDeadMachineByBooze(){
        System.out.println(student + " говорит: Спасибо за лекции, сейчас применю знания на практике, всем советую убегать!");
    }

    public void imStupid(){
        System.out.println(student + " говорит: Извините, но я ничего не понял про экономию...");
    }
}
