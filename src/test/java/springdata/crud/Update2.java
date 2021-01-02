package springdata.crud;

import com.github.javafaker.Faker;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Update2 {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Faker faker = new Faker();
        // 修改資料
        // 1.建立 User 物件(游離物件, 含有 id 內容)
        User user = new User();
        user.setId(1L);
        user.setName("Vincent");
        user.setEmail("Vincent@psschool.com");
        user.setBirth(new Date());
        // 2.修改(與新增同)
        userRepository.save(user);
        System.out.println("OK");
        ctx.close();
                
    }
}
