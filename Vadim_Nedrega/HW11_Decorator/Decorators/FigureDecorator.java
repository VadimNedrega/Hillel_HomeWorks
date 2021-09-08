package vadim_nedrega.HW11_Decorator.Decorators;

import vadim_nedrega.HW11_Decorator.Objects.Component;

public class FigureDecorator extends Decorator {
    public FigureDecorator(Component component) {
        super(component);
    }

    @Override
    public void extraAdd() {
        System.out.println("Added chess figures");
    }
}
