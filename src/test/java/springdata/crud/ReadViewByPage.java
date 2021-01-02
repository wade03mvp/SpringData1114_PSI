package springdata.crud;

import com.spring.mvc.psi.entities.UserView;
import com.spring.mvc.psi.repository.UserViewRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class ReadViewByPage {
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-config.xml");
        UserViewRepository userViewRepository = ctx.getBean(UserViewRepository.class);
        
        // 分頁設定
        int pageNo = 0; // 分頁是從 0 開始
        int pageSize = 10; // 每頁 10 筆
        // 排序設定
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "age");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order1, order2);
        // 建立分頁請求
        // PageRequest(int pageNo, int pageSize, Sort sort) 
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
        
        Page<UserView> pageUser = userViewRepository.findAll(pageRequest);
        List<UserView> users = pageUser.getContent();
        
        System.out.println(users);
                
        ctx.close();
                
    }
}
