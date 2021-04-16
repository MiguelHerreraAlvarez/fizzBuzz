package unit_tests;

import org.junit.jupiter.api.*;
import tirepressuremonitoringsystem.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlarmTest {

    @Test
    public void given_pressure_lower_than_low_pressure_threashold_then_alarm_is_on() {
        var alarmAlerter = new TestAlarmAlerter();
        var sensor = new TestSensor(15);
        var alarm = new Alarm(sensor, alarmAlerter);

        alarm.check();

        assertEquals(alarmAlerter.getAlert(), "Alarm activated!");
    }

    @Test
    public void given_pressure_higer_than_high_pressure_threashold_then_alarm_is_on() {
        var alarmAlerter = new TestAlarmAlerter();
        var sensor = new TestSensor(22);
        var alarm = new Alarm(sensor, alarmAlerter);

        alarm.check();

        assertEquals(alarmAlerter.getAlert(), "Alarm activated!");
    }

    @Test
    public void given_alarm_turned_on_when_pressure_backs_normal_then_switch() {
        var alarmAlerter = new TestAlarmAlerter();
        var sensor = new TestSensor(22);
        var alarm = new Alarm(sensor, alarmAlerter);

        alarm.check();
        assertEquals(alarmAlerter.getAlert(), "Alarm activated!");
        sensor.setPressure(18);

        alarm.check();

        assertEquals(alarmAlerter.getAlert(), "Alarm deactivated!");
    }
}

