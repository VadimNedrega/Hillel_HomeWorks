package vadim_nedrega.HW16_3Patterns.AbstractFactory.Customer;

public class Customer {
    private String name;
    private boolean isCommunist;

    public Customer(String name, boolean isCommunist) {
        this.name = name;
        this.isCommunist = isCommunist;
    }

    public boolean isCommunist() {
        return isCommunist;
    }
}
