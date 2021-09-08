package vadim_nedrega.HW10_Builder_Filter.Builder;

public class CreateTV {
    private final int diagonal;
    private final String matrix;
    private final String color;
    private final boolean hasSmartTv;

    public int getDiagonal() {
        return diagonal;
    }

    public String getMatrix() {
        return matrix;
    }

    public String getColor() {
        return color;
    }

    public boolean isHasSmartTv() {
        return hasSmartTv;
    }

    private CreateTV(String manufacturer, int diagonal, String matrix, String color, boolean hasSmartTv) {
        this.diagonal = diagonal;
        this.matrix = matrix;
        this.color = color;
        this.hasSmartTv = hasSmartTv;
    }

    public static class Builder {
        private final String manufacturer;
        private int diagonal;
        private String matrix;
        private String color;
        private boolean hasSmartTv;

        public Builder(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Builder setDiagonal(int diagonal) {
            this.diagonal = diagonal;
            return this;
        }

        public Builder setMatrix(String matrix) {
            this.matrix = matrix;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setHasSmartTv(boolean hasSmartTv) {
            this.hasSmartTv = hasSmartTv;
            return this;
        }

        public CreateTV build() {
            return new CreateTV(manufacturer, diagonal, matrix, color, hasSmartTv);
        }
    }

}
