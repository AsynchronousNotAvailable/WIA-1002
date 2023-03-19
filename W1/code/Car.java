package W1.code;

public class Car extends Vehicle {

    // Constructor
    public Car(double maxSpeed) {
        super(maxSpeed);
    }

    // Methods
    public void accelerate() {
        super.currentSpeed++;
    }
}

