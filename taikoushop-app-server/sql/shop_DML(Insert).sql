insert into Commodity (item_id , item_Name,price ,photo_Path ,photo_Name ,off_Flag) values('b4fd1e96-419b-4cd6-a620-d240b845723c', 'iphone 11' , 25900 , '' ,'' ,'1');

INSERT INTO `shop_commodity`.`commodity_stock`(`item_id`,`stock_quantity`,`sold_quantity`,`created_by`,`updated_by`)VALUES
('b4fd1e96-419b-4cd6-a620-d240b845723c' , 100 ,'1', 'poshen' , 'poshen');


insert into commodity_comment(`uuid`,`Item_id`,`Store_id`,`Score`,`comments`,`customer_id`,`customer_name`,`created_by`,`updated_by`)VALUES
('9ad785df-2741-41ac-9c9d-d45dfbbe59f2','b4fd1e96-419b-4cd6-a620-d240b845723c', '221f830d-a177-4a99-ab24-a6cb9080313d' ,'5','test comments', '840eea03-26be-4d72-ad60-98dad090efdd' , 'poshen' , 'poshen','poshen');

INSERT INTO `shop_commodity`.`store_comment`(`uuid`,`Store_id`,`Store_star`,`Comments`,`created_by`,`updated_by`)VALUES
('fe12d461-52ec-4ed9-99c5-b25603ae1d93' , '221f830d-a177-4a99-ab24-a6cb9080313d' , 5 , 'test comments' , 'poshen' , 'poshen');

INSERT INTO `shop_commodity`.`store_detail`(`Store_id`,`store_number`,`Store_name`,`Introduction`,`Phone`,`Telephone`,`Mail`,`created_by`,`updated_by`)VALUES
('221f830d-a177-4a99-ab24-a6cb9080313d' , 1 , 'poshen store' , 'this is introduction' , '0909090909' , '' , 'test@gmail.com' ,'poshen' , 'poshen');




