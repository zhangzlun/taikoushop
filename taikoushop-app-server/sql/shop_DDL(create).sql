
# 商品詳細內容
create table Commodity(
	Item_id char(36),
	Item_name varchar(20) , 
    price numeric,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by bigint(20) default null,
	updated_by bigint(20) default null,
	Photo_path varchar(60),
	Photo_name varchar(20),
	Off_flag char(1)
);

# 商品數量
create table commodity_stock(
	item_id char(36) primary key,
    stock_quantity numeric ,
    sold_quantity numeric ,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by char(36) default null,
	updated_by char(36) default null
);

# 商品評論 & 資訊
create table commodity_comment(
	uuid char(36) primary key,
	Item_id char(36), 
	Store_id char(36),
	Score int,
	comments varchar(100),
    customer_id char(36),
    customer_name varchar(20),
	
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by char(36) default null,
	updated_by char(36) default null
);


# 店家詳細資訊
create table store_detail(
	Store_id char(36) primary key,
    store_number bigint(10),
	Store_name varchar(20),
	Introduction varchar(200),
	Phone char(10),
	Telephone char(15) ,
	Mail varchar(50),
	
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by char(36) default null,
	updated_by char(36) default null
);


# store 評論 & 評分
create table store_comment(
	uuid char(36) primary key,
	Store_id char(36),
	Store_star bigint(10),
	Comments varchar(100),
	
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by char(36) default null,
	updated_by char(36) default null
);









#alter table commodity add column price numeric;

#rename table commodity_amount to commodity_detail;
