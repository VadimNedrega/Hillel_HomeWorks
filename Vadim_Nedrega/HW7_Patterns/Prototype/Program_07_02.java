package vadim_nedrega.HW7_Patterns.Prototype;

public class Program_07_02 {
    public static void main(String[] args) {
        createTV createTv = new SamsungCreateTV(50, "IPS", "Черный", true, "Samsung SA-123");
        createTV createTv1 = new CheapChinaCreateTV(84, "VA", "Черный", false, "Super China TV");

        System.out.println(createTv);
        System.out.println(createTv1);

        createTv.clone();
        createTv1.clone();

        createTv.setColor("Серый");
        createTv.setDiagonal(55);

        createTv1.setHasSmartTv(true);
        createTv1.setColor("Розовый");

        System.out.println(createTv);
        System.out.println(createTv1);

    }
}
