package vadim_nedrega.HW16_3Patterns.AbstractFactory.MeansOfCommunication.Telegraph;

import vadim_nedrega.HW16_3Patterns.AbstractFactory.ConnectionInterfaces.Telegraph;

public class RadioElectronica1890 implements Telegraph {
    @Override
    public void addMessage() {
        System.out.println("Звуки печатной машинки...");
    }

    @Override
    public void reviewMessage() {
        System.out.println("ООО, пришло");
    }
}
