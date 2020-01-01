DROP TABLE "Product_comment";

CREATE TABLE "Product_comment"
(
  "product_id" VARCHAR2(36)  NOT NULL,
  "store_id"   VARCHAR2(36)  NOT NULL,
  "star"       NUMBER        NULL,
  "comment"    VARCHAR2(200) NULL,
  "user_id"    VARCHAR2(36)  NOT NULL,
  "user_name"  VARCHAR2(36)  NULL,
  "created_at" TIMESTAMP     NULL,
  "created_by" VARCHAR2(36)  NULL,
  "sort"       NUMBER DEFAULT generated always as identity NOT NULL,
  PRIMARY KEY ("product_id", "store_id", "user_id", "sort")
)
  NOCOMPRESS
  NOPARALLEL;