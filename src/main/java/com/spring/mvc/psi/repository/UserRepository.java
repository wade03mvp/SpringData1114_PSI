package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/*
方法命名規則
1. 查詢方法的前綴詞: find | read | get
2. 若涉及條件查詢時, 屬姓名的字首為大寫, 後面可以用條件關鍵字(And | Or | In)連結
3. 若要使用聯級屬性, 則屬性要使用 _ 進行連結
    Ex: getByNameAndSalary_Id() -> 根據 User 的 name 與 Salary 的 id 來找到該筆 User 資料
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // 根據 name 來取得 User
    User getByName(String name);
    
    // SQL 條件: Where name LIKE ?% AND id < ?
    List<User> getByNameStartingWithAndIdLessThan(String name, Long id);
    
    // SQL 條件: Where id in (?, ?, ? ...) AND birth >= ?
    List<User> getByIdInAndBirthGreaterThanEqual(List<Long> ids, Date birth);
    
    // SQL 條件(有幾筆資料):
    // nativeQuery = true 表示使用 T-SQL
    @Query(value = "SELECT count(id) FROM T_USER", nativeQuery = true)
    Long getTotalCount();
    
    // SQL 條件: SELECT * FROM T_USER u WHERE YEAR(CURRENT_DATE)-YEAR(u.birth) >= 65
    // 查詢已退休人員 , nativeQuery = false(預設) 表示使用 JPQL
    // :age 會對應方法的 Integer age 參數 或使用 ?1 表示可對應方法的第一個參數
    @Query(value = "SELECT u FROM User u WHERE YEAR(CURRENT_DATE)-YEAR(u.birth) >= :age", nativeQuery = false)
    List<User> getRetireUsers(Integer age);
    
    // 查詢 id 值最大的 User
    @Query(value = "SELECT u FROM User u WHERE u.id = (SELECT MAX(u2.id) FROM User u2)")
    User getMaxIdUser();
}
