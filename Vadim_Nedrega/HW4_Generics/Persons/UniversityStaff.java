package vadim_nedrega.HW4_Generics.Persons;

import vadim_nedrega.HW4_Generics.Human;

public interface UniversityStaff <T extends Human> {
    void teach(T t);
}
