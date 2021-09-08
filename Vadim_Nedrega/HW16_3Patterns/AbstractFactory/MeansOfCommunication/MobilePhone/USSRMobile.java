package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.MobilePhone;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.MobilePhone;

public class USSRMobile implements MobilePhone {
    @Override
    public void dial() {
        System.out.println("А ну соединяй говорю!");
    }

    @Override
    public void createSMS() {
        System.out.println("Какое к черту смс?");
    }

    @Override
    public void endCall() {
        System.out.println("Да выключись уже!");
    }
}
