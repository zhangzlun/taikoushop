DROP TABLE "product_subscribe";

CREATE TABLE "product_subscribe"
(
  "product_id" VARCHAR2(36) NOT NULL,
  "user_id"    VARCHAR2(36) NOT NULL,
  PRIMARY KEY ("product_id", "user_id")
)
  NOCOMPRESS
  NOPARALLEL;