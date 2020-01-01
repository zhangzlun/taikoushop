DROP TABLE "Product_detail";

CREATE TABLE "Product_detail"
(
  "product_id"          VARCHAR2(36)   NOT NULL,
  "spec_type"           VARCHAR2(10)   NOT NULL,
  "introduction_spec"   VARCHAR2(300)  NULL,
  "introduction_detail" VARCHAR2(1000) NULL,
  "spec"                VARCHAR2(30)   NULL,
  "price"               NUMBER         NULL,
  "stock_quantity"      NUMBER         NULL,
  "sold_quantity"       NUMBER         NULL,
  "status"              CHAR(1)        NULL,
  "created_at"          TIMESTAMP      NULL,
  "created_by"          VARCHAR2(36)   NULL,
  "updated_at"          TIMESTAMP      NULL,
  "updated_by"          VARCHAR2(36)   NULL,
  PRIMARY KEY ("product_id")
)
  NOCOMPRESS
  NOPARALLEL;