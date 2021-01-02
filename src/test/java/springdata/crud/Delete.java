package springdata.crud;

import com.github.javafaker.Faker;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Delete {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        // 刪除資料
        userRepository.delete(143L);
        System.out.println("OK");
        ctx.close();
                
    }
}
