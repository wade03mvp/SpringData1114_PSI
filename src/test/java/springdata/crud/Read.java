package springdata.crud;

import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
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
        // SQL 條件: Where name LIKE ?% AND id < ?
        System.out.println(
                userRepository.getByNameStartingWithAndIdLessThan("A", 50L)
        );
        // SQL 條件: Where id in (?, ?, ? ...) AND birth >= ?
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(
                userRepository.getByIdInAndBirthGreaterThanEqual(
                        Arrays.asList(1L, 3L, 5L, 7L, 9L),
                        date
                )
        );
        // 有幾筆資料
        System.out.println(
                userRepository.getTotalCount()
        );
        ctx.close();
                
    }
}
