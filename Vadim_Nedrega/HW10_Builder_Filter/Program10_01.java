package vadim_nedrega.HW10_Builder_Filter;

import vadim_nedrega.HW10_Builder_Filter.Builder.CreateTV;

public class Program10_01 {
    public static void main(String[] args) {
        String tv = "Samsung";
        CreateTV samsung = new CreateTV.Builder(tv)
                .setColor("grey")
                .setDiagonal(50)
                .setMatrix("IPS")
                .setHasSmartTv(true)
                .build();
        System.out.println("Телевизор: " + tv);
        System.out.println("Матрица: " + samsung.getMatrix());
        System.out.println("Цвет: " + samsung.getColor());
        System.out.println("Диагональ: " + samsung.getDiagonal());
        System.out.println("Функция Smart TV: " + samsung.isHasSmartTv());

        String tv1 = "Super China";
        CreateTV superChina = new CreateTV.Builder(tv1)
                .setColor("White")
                .setMatrix("VA")
                .build();

        System.out.println("==============================================");

        System.out.println("Телевизор: " + tv1);
        System.out.println("Матрица: " + superChina.getMatrix());
        System.out.println("Цвет: " + superChina.getColor());
    }
}
