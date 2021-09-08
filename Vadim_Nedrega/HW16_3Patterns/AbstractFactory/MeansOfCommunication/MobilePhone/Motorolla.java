package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.MobilePhone;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.MobilePhone;

public class Motorolla implements MobilePhone {
    @Override
    public void dial() {
        System.out.println("Dial");
    }

    @Override
    public void createSMS() {
        System.out.println("Typing sms");
    }

    @Override
    public void endCall() {
        System.out.println("End call");
    }
}
