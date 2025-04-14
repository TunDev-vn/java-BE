package buoi10.designparttern.observers;

import buoi10.designparttern.observers.model.Observer;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAllObservers();
}
