DROP TABLE "store_subscribe";

CREATE TABLE "store_subscribe"
(
  "store_id" VARCHAR2(36) NOT NULL,
  "user_id"  VARCHAR2(36) NOT NULL,
  PRIMARY KEY ("store_id", "user_id")
)
  NOCOMPRESS
  NOPARALLEL;