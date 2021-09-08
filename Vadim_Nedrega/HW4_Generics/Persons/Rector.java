package vadim_nedrega.HW4_Generics.Persons;


public class Rector extends Staff implements UniversityStaff<Staff> {
    String name = "Ректор Главнюк";
    String staff;

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void teach(Staff staff) {
        System.out.println(name + " :Учить вас и учить...");
    }

    public void kickAssSubordinate (Staff staff){
        System.out.println(name + " Лепит выговор декану");
    }

}
