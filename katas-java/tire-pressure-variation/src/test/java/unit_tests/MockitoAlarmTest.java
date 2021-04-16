package unit_tests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tirepressuremonitoringsystem.Alarm;
import tirepressuremonitoringsystem.AlarmAlerter;
import tirepressuremonitoringsystem.Sensor;

public class MockitoAlarmTest {

    @Test
    public void given_pressure_lower_than_low_pressure_threashold_then_alarm_is_on() {
        var alarmAlerter = Mockito.mock(AlarmAlerter.class);
        var sensor = Mockito.mock(Sensor.class);
        var alarm = new Alarm(sensor, alarmAlerter);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15d);

        alarm.check();

        Mockito.verify(alarmAlerter).activateAlert();
    }

    @Test
    public void given_pressure_higer_than_high_pressure_threashold_then_alarm_is_on() {
        var alarmAlerter = Mockito.mock(AlarmAlerter.class);
        var sensor = Mockito.mock(Sensor.class);
        var alarm = new Alarm(sensor, alarmAlerter);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22d);

        alarm.check();

        Mockito.verify(alarmAlerter).activateAlert();
    }

    @Test
    public void given_alarm_turned_on_when_pressure_backs_normal_then_switch() {
        var alarmAlerter = Mockito.mock(AlarmAlerter.class);
        var sensor = Mockito.mock(Sensor.class);
        var alarm = new Alarm(sensor, alarmAlerter);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22d);

        alarm.check();
        Mockito.verify(alarmAlerter).activateAlert();
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18d);

        alarm.check();

        Mockito.verify(alarmAlerter).deactivateAlert();
    }

}
