package vadim_nedrega.HW4_Generics;

public interface University <T extends Human> {
    void giveEducation(T student);
    void giveJob(T universityStaff);

}
