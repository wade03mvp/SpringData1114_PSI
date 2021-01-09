-- 庫存 2
-- 建立一個View, 名稱 : Inventory2
SELECT i.id, 
       i."NAME", 
       i.image,
       i.PU_QTY-coalesce(i.SA_QTY, 0) qty, -- coalesce 合併(若 i.SA_QTY = null 則顯示 0)
       i.PU_TOTAL/i.PU_QTY as pu_cost , -- 進貨均價 
       i.SA_TOTAL/i.SA_QTY as sa_cost , -- 銷貨均價
       CAST(i.PU_TOTAL/i.PU_QTY/0.3 AS INTEGER) as price1 , -- 建議售價 1 (會員價)
       CAST(i.PU_TOTAL/i.PU_QTY/0.2 AS INTEGER) as price2   -- 建議售價 2 (非會員價)
FROM INVENTORY i

