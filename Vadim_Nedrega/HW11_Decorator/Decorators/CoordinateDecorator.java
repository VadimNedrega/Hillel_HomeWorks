package vadim_nedrega.HW11_Decorator.Decorators;

import vadim_nedrega.HW11_Decorator.Objects.Component;

public class CoordinateDecorator extends Decorator {
    public CoordinateDecorator(Component component) {
        super(component);
    }

    @Override
    public void extraAdd() {
        System.out.println("Added coordinates for board");
    }
}
