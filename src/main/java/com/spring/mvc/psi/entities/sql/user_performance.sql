--每件商品的庫存量
SELECT i.name, i.qty FROM INVENTORY2 i;
--每件商品的進貨成本
SELECT i.name, i.PU_COST FROM INVENTORY2 i;

-- 每一個業務員(User)的業績
-- 建立一個View, 名稱 : UserPerfoemance
SELECT u."NAME", SUM(s.PRICE * s.QUANTITY) as profit 
FROM Sales s, T_User u
WHERE s.USER_ID = u.ID
GROUP BY u."NAME"


