package springdata.crud;

import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Read {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        // 單筆查詢
        User u1 = userRepository.findOne(1L);
        System.out.println(u1);
        // 多筆查詢
        List<User> users = userRepository.findAll();
        System.out.println(users);
        // 根據 name 來取得 User
        User u2 = userRepository.getByName("Vincent");
        System.out.println(u2);
        
        ctx.close();
                
    }
}
