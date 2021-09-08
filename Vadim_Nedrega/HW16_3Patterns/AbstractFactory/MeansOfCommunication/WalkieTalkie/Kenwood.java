package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.WalkieTalkie;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.RadioCommutation;

public class Kenwood implements RadioCommutation {
    @Override
    public void startTalking() {
        System.out.println("Hello, friends");
    }

    @Override
    public void endTalking() {
        System.out.println("Buy...");
    }
}
