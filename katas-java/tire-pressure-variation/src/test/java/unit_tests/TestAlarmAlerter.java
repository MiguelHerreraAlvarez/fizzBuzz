package unit_tests;

import tirepressuremonitoringsystem.*;

public class TestAlarmAlerter implements AlarmAlerter {

    private String alert;

    public String getAlert() {
        return alert;
    }

    @Override
    public void activateAlert() {
        alert = "Alarm activated!";
    }

    @Override
    public void deactivateAlert() {
        alert = "Alarm deactivated!";
    }
}
