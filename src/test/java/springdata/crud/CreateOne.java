package springdata.crud;

import com.github.javafaker.Faker;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateOne {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Faker faker = new Faker();
        // 新增單筆
        User user = new User();
        user.setName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setBirth(faker.date().birthday());
        userRepository.save(user);
        System.out.println("OK");
        ctx.close();
                
    }
}
