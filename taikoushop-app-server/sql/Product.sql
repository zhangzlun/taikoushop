DROP TABLE "Product";

drop table Product;

CREATE TABLE product
(
  "product_id" VARCHAR2(36) NOT NULL,
  "store_id"   VARCHAR2(36) NOT NULL,
  "name"       VARCHAR2(36) NULL,
  "price"      NUMBER       NULL,
  "created_at" Timestamp         NULL,
  "created_by" VARCHAR2(36) NULL,
  "updated_at" Timestamp         NULL,
  "updated_by" VARCHAR2(36) NULL,
  "photo_name" VARCHAR2(20) NULL,
  "photo_path" VARCHAR2(60) NULL,
  "status"   VARCHAR2(1)  NULL,
  PRIMARY KEY ("product_id", "store_id")
)
  NOCOMPRESS
  NOPARALLEL;

select * from Product;

select * from product;

insert into product("product_id" , "store_id" , "name") values
('productid' , 'storeid' , 'name');
