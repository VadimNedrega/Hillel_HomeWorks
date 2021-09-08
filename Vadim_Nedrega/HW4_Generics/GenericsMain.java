package vadim_nedrega.HW4_Generics;

import vadim_nedrega.HW4_Generics.Departmens.DepartmentOfEconomics;
import vadim_nedrega.HW4_Generics.Departmens.MechanicalDepartment;
import vadim_nedrega.HW4_Generics.Departmens.MoonshinersDepartment;
import vadim_nedrega.HW4_Generics.Departmens.ThisUniversity;
import vadim_nedrega.HW4_Generics.Persons.Dean.BoozeDean;
import vadim_nedrega.HW4_Generics.Persons.Dean.EconomicDean;
import vadim_nedrega.HW4_Generics.Persons.Dean.MechDean;
import vadim_nedrega.HW4_Generics.Persons.Lector.BoozeLector;
import vadim_nedrega.HW4_Generics.Persons.Lector.EconomLector;
import vadim_nedrega.HW4_Generics.Persons.Lector.MechLector;
import vadim_nedrega.HW4_Generics.Persons.Rector;
import vadim_nedrega.HW4_Generics.Persons.Student.Student;


public class GenericsMain {
    public static void main(String[] args) {

        Rector rector = new Rector();

        EconomLector economLector = new EconomLector();
        BoozeLector boozeLector = new BoozeLector();
        MechLector mechLector = new MechLector();

        EconomicDean economicDean = new EconomicDean();
        BoozeDean boozeDean = new BoozeDean();
        MechDean mechDean = new MechDean();

        Student student1 = new Student();
        student1.setStudent("Валера");
        Student student2 = new Student();
        student2.setStudent("Петро");
        Student student3 = new Student();
        student3.setStudent("Кеша");

        ThisUniversity university = new ThisUniversity();
        DepartmentOfEconomics departmentOfEconomics = new DepartmentOfEconomics();
        MechanicalDepartment mechanicalDepartment = new MechanicalDepartment();
        MoonshinersDepartment moonshinersDepartment = new MoonshinersDepartment();

        university.giveJob(rector);
        departmentOfEconomics.giveJob(economicDean);
        departmentOfEconomics.giveJob(economLector);

        mechanicalDepartment.giveJob(mechLector);
        mechanicalDepartment.giveJob(mechDean);

        moonshinersDepartment.giveJob(boozeLector);
        moonshinersDepartment.giveJob(boozeDean);

        boozeDean.teach(boozeLector);
        boozeLector.doBooze();
        boozeLector.teach(student1);
        economicDean.teach(student1);
        mechLector.teach(student1);
        mechLector.doDeadMachine();
        System.out.println("=====================");
        student1.imStupid();

        rector.kickAssSubordinate(economicDean);
        economicDean.teach(economLector);
        economLector.teach(student1);

        student1.doEconomDeadMachineByBooze();





























    }
}
