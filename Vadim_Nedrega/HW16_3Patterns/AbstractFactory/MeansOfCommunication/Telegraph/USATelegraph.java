package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.Telegraph;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.Telegraph;

public class USATelegraph implements Telegraph {
    @Override
    public void addMessage() {
        System.out.println("typewriter sounds...");
    }

    @Override
    public void reviewMessage() {
        System.out.println("OMG, I can see this");
    }
}
