package tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private final Sensor sensor;
    private final AlarmAlerter realAlarmAlerter;
    private boolean alarmOn = false;

    public Alarm(final Sensor sensor, final AlarmAlerter realAlarmAlerter) {
        this.sensor = sensor;
        this.realAlarmAlerter = realAlarmAlerter;
    }

    public Alarm() {
        this.sensor = new RealSensor();
        this.realAlarmAlerter = new RealAlarmAlerter();
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            if(!isAlarmOn()) {
                alarmOn = true;
                realAlarmAlerter.activateAlert();
            }
        } else {
            if(isAlarmOn()) {
                alarmOn = false;
                realAlarmAlerter.deactivateAlert();
            }
        }
    }


    private boolean isAlarmOn() {
        return alarmOn;
    }
}
