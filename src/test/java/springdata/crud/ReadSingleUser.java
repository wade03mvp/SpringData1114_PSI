package springdata.crud;

import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserPerformanceRepository;
import com.spring.mvc.psi.repository.UserRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadSingleUser {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserPerformanceRepository upr = ctx.getBean(UserPerformanceRepository.class);
        System.out.println(upr.findAll());
        ctx.close();
                
    }
}
