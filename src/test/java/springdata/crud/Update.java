package springdata.crud;

import com.github.javafaker.Faker;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Update {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Faker faker = new Faker();
        // 修改資料
        // 1.查詢要修改的 User 物件
        User user = userRepository.findOne(1L);
        user.setName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setBirth(faker.date().birthday());
        // 2.修改(與新增同)
        userRepository.save(user);
        System.out.println("OK");
        ctx.close();
                
    }
}
