package tirepressuremonitoringsystem;

public class AlarmChecker {

    private Boolean alarmOn = false;

    public Boolean isAlarmOn() {
        return this.alarmOn;
    }

    public void setAlarmOn(boolean isAlarmOn) {
        this.alarmOn = isAlarmOn;
    }
}
