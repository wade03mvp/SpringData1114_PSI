package springdata.crud;

import com.spring.mvc.psi.repository.UserViewRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadView {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserViewRepository userViewRepository = ctx.getBean(UserViewRepository.class);
        System.out.println(
            userViewRepository.findAll()
        );
        
        ctx.close();
                
    }
}
