package vadim_nedrega.HW8_Observer;

public interface Observable {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserversAboutStopTheKiln();

    void notifyObserversAboutStartTheKiln();
}
