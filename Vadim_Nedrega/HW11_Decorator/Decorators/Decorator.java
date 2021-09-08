package vadim_nedrega.HW11_Decorator.Decorators;

import vadim_nedrega.HW11_Decorator.Objects.Component;

public abstract class Decorator implements Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public abstract void extraAdd();

    @Override
    public void add() {
        component.add();
        extraAdd();
    }
}
