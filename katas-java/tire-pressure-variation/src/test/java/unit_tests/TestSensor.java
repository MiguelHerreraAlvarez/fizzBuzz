package unit_tests;

import tirepressuremonitoringsystem.*;

public class TestSensor implements Sensor {

    private double pressure;

    public TestSensor(double desiredPressure) {
        this.pressure = desiredPressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public double popNextPressurePsiValue() {
        return this.pressure;
    }
}
