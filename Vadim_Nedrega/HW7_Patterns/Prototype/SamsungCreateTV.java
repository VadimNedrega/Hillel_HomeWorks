package vadim_nedrega.HW7_Patterns.Prototype;

public class SamsungCreateTV extends createTV {
    private String model;

    public SamsungCreateTV(int diagonal, String matrix, String color, boolean hasSmartTv, String model) {
        super(diagonal, matrix, color, hasSmartTv);
        this.model = model;
    }

    @Override
    public String toString() {
        return ("Телевизор " + model + ", тип матрицы " + getMatrix() + ", Цвет " + getColor() + ", Функция SmartTV "
                + isHasSmartTv());
    }
}
