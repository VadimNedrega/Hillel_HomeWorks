package vadim_nedrega.HW7_Patterns.Null_Object;

public class Guest implements User{
    private String name = "Guest";
    @Override
    public void searchWebSite() {
        System.out.println("Вы зашли на сайт как " + name + ", Вам не будет доступна функция добавления комментариев");
    }
}
