package springdata;

import com.github.javafaker.Faker;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Faker faker = new Faker();
        // 新增多筆
        List<User> users = new ArrayList<>();
        IntStream.rangeClosed(1, 142).forEach(i -> {
            User user = new User();
            user.setName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setBirth(faker.date().birthday());
            users.add(user);
        });
        userRepository.save(users);
        System.out.println("OK");
        ctx.close();
                
    }
}
