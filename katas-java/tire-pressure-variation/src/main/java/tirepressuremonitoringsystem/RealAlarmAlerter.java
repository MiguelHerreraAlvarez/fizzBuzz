package tirepressuremonitoringsystem;

public class RealAlarmAlerter implements AlarmAlerter {

    @Override
    public void alert(String alert) {
        System.out.print(alert);
    }
}
