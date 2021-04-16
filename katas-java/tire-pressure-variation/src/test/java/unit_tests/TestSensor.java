package unit_tests;

import tirepressuremonitoringsystem.*;

public class TestSensor implements Sensor {

    private double preassure;

    public TestSensor(double desiredPreassure) {
        this.preassure = desiredPreassure;
    }

    public void setPreassure(double preassure) {
        this.preassure = preassure;
    }

    @Override
    public double popNextPressurePsiValue() {
        return this.preassure;
    }
}
