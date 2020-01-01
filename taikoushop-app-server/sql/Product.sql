DROP TABLE "Product";


CREATE TABLE "Product"
(
  "product_id" VARCHAR2(36) NOT NULL,
  "store_id"   VARCHAR2(36) NOT NULL,
  "name"       VARCHAR2(36) NULL,
  "price"      NUMBER       NULL,
  "created_at" DATE         NULL,
  "created_by" VARCHAR2(36) NULL,
  "updated_at" DATE         NULL,
  "updated_by" VARCHAR2(36) NULL,
  "photo_name" VARCHAR2(20) NULL,
  "photo_path" VARCHAR2(60) NULL,
  "off_flag"   VARCHAR2(1)  NULL,
  PRIMARY KEY ("product_id", "store_id")
)
  NOCOMPRESS
  NOPARALLEL;