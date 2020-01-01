DROP TABLE "Store";


CREATE TABLE "Store"
(
  "store_id"     VARCHAR2(36)   NOT NULL,
  "store_name"   VARCHAR2(36)   NULL,
  "introduction" VARCHAR2(1000) NULL,
  "phone"        CHAR(10)       NULL,
  "mail"         VARCHAR2(50)   NULL,
  "create_at"    TIMESTAMP      NULL,
  "create_by"    VARCHAR2(36)   NULL,
  PRIMARY KEY ("store_id")
)
  NOCOMPRESS
  NOPARALLEL;