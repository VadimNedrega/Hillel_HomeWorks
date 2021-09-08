package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.WalkieTalkie;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.RadioCommutation;

public class P159 implements RadioCommutation {
    @Override
    public void startTalking() {
        System.out.println("Прием...Коммунисты, вы меня слышите?");
    }

    @Override
    public void endTalking() {
        System.out.println("Та ну вас...");
    }
}
