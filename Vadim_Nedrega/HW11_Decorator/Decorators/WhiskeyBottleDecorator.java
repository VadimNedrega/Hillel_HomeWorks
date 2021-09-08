package vadim_nedrega.HW11_Decorator.Decorators;

import vadim_nedrega.HW11_Decorator.Objects.Component;

public class WhiskeyBottleDecorator extends Decorator {
    public WhiskeyBottleDecorator(Component component) {
        super(component);
    }

    @Override
    public void extraAdd() {
        System.out.println("Added bottle of whiskey on board for drunk chess");
    }
}
