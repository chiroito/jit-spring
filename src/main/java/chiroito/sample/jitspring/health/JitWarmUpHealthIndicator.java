package chiroito.sample.jitspring.health;

import chiroito.sample.JitWarmUpMXBean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Component
public class JitWarmUpHealthIndicator implements HealthIndicator {

    private JitWarmUpMXBean jitWarmUpMXBean;

    public JitWarmUpHealthIndicator() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName mxbeanName = new ObjectName("com.example:type=JitWarmUp");
            this.jitWarmUpMXBean = JMX.newMBeanProxy(mbs, mxbeanName, JitWarmUpMXBean.class);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Health health() {
        return jitWarmUpMXBean != null && jitWarmUpMXBean.isWarmedUp() ? Health.up().build() : Health.down().build();
    }
}
