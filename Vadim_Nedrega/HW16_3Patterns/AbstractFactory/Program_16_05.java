package vadim_nedrega.HW16_3Patterns.AbstractFactory;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.CommunicationFactory.USAFactory;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.CommunicationFactory.USSRFactory;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.Customer.Customer;
import vadim_nedrega.HW16_3Patterns.AbstractFactory.FactoryInterface.ConnectionFactory;

public class Program_16_05 {
    public static void main(String[] args) {
        Customer customer = new Customer("Leonid", true);

        ConnectionFactory factory;
        if (customer.isCommunist()) {
            factory = new USSRFactory();
        } else {
            factory = new USAFactory();
        }

        factory.createMobilePhone().createSMS();
        factory.createTelegraph().reviewMessage();
        factory.createRadioCommutation().startTalking();
    }
}
