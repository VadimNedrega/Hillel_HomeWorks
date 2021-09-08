package vadim_nedrega.HW16_3Patterns.AbstractFactory.CommunicationFactory;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.MobilePhone;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.RadioCommutation;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.Telegraph;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.FactoryInterface.ConnectionFactory;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.MobilePhone.Motorolla;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.Telegraph.USATelegraph;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.WalkieTalkie.Kenwood;

public class USAFactory implements ConnectionFactory {
    @Override
    public MobilePhone createMobilePhone() {
        return new Motorolla();
    }

    @Override
    public RadioCommutation createRadioCommutation() {
        return new Kenwood();
    }

    @Override
    public Telegraph createTelegraph() {
        return new USATelegraph();
    }
}
