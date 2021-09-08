package vadim_nedrega.HW11_Decorator.Decorators;

import vadim_nedrega.HW11_Decorator.Objects.Component;

public class CellDecorator extends Decorator {
    public CellDecorator(Component component) {
        super(component);
    }

    @Override
    public void extraAdd() {
        System.out.println("Added cells for board");
    }
}
