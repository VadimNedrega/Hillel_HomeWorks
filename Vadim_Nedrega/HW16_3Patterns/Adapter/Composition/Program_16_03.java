package vadim_nedrega.HW16_3Patterns.Adapter.Composition;

public class Program_16_03 {
    public static void main(String[] args) {
        @SuppressWarnings("all")
        Cat1 cat1 = (Cat1) new CatAdapter1();
        System.out.println(cat1.sleep());
        System.out.println(cat1.eat());
        System.out.println(cat1.move());
    }
}
