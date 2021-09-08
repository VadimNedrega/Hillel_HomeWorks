package vadim_nedrega.HW7_Patterns.Null_Object;

public class RegisteredUser implements User{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegisteredUser() {
    }

    public RegisteredUser(String name) {
        this.name = name;
    }

    @Override
    public void searchWebSite() {
        System.out.println("Вы зашли на сайт как " + name + " с возможностью пользоваться сайтом без ограничений");
    }

    @Override
    public String toString() {
        return getName();
    }
}
