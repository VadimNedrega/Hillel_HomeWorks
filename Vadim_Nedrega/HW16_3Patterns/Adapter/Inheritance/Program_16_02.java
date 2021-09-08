package vadim_nedrega.HW16_3Patterns.Adapter.Inheritance;

public class Program_16_02 {
    public static void main(String[] args) {
        Cat cat = new CatAdapter();
        System.out.println(cat.sleep());
        System.out.println(cat.eat());
        System.out.println(cat.move());
    }
}
