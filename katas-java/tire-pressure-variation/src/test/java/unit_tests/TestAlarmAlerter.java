package unit_tests;

import tirepressuremonitoringsystem.*;

public class TestAlarmAlerter implements AlarmAlerter {

    private String alert;

    @Override
    public void alert(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return alert;
    }
}
