package tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;
    private AlarmAlerter realAlarmAlerter;
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
        double psiPressureValue = getSensorPressure();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            if(!isAlarmOn()) {
                alarmOn = true;
                alert("Alarm activated!");
            }
        } else {
            if(isAlarmOn()) {
                alarmOn = false;
                alert("Alarm deactivated!");
            }
        }
    }

    protected void alert(String text) {
        realAlarmAlerter.alert(text);
    }

    protected double getSensorPressure() {
        return sensor.popNextPressurePsiValue();
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
