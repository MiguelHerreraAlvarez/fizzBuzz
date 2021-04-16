package tirepressuremonitoringsystem;

public class RealAlarmAlerter implements AlarmAlerter {

    @Override
    public void activateAlert() {
        System.out.println("Alarm activated!");
    }

    @Override
    public void deactivateAlert() {
        System.out.println("Alarm deactivated!");
    }
}
