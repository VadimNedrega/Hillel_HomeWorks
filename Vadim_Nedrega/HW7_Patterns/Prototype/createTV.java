package vadim_nedrega.HW7_Patterns.Prototype;

public class createTV implements Cloneable {
    private int diagonal;
    private String matrix;
    private String color;
    private boolean hasSmartTv;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasSmartTv() {
        return hasSmartTv;
    }

    public void setHasSmartTv(boolean hasSmartTv) {
        this.hasSmartTv = hasSmartTv;
    }

    public createTV() {
    }

    public createTV(int diagonal, String matrix, String color, boolean hasSmartTv) {
        this.diagonal = diagonal;
        this.matrix = matrix;
        this.color = color;
        this.hasSmartTv = hasSmartTv;
    }

    @Override
    public Object clone() {
        return new createTV(this.diagonal, this.matrix, this.color, this.hasSmartTv);
    }

    @Override
    public String toString() {
        return ("Телевизор " + ", тип матрицы " + matrix + ", Цвет " + color + ", Функция SmartTV " + hasSmartTv);
    }
}
