package vadim_nedrega.HW16_3Patterns.AbstractFactory.CommunicationFactory;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.MobilePhone;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.RadioCommutation;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.Telegraph;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.FactoryInterface.ConnectionFactory;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.MobilePhone.USSRMobile;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.Telegraph.RadioElectronica1890;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.WalkieTalkie.P159;

public class USSRFactory implements ConnectionFactory {
    @Override
    public MobilePhone createMobilePhone() {
        return new USSRMobile();
    }

    @Override
    public RadioCommutation createRadioCommutation() {
        return new P159();
    }

    @Override
    public Telegraph createTelegraph() {
        return new RadioElectronica1890();
    }
}
