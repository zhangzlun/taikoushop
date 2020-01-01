DROP TABLE "Store_comment";

CREATE TABLE "Store_comment"
(
  "store_id"   VARCHAR2(36)  NOT NULL,
  "sort"       NUMBER DEFAULT generated always as identity NOT NULL,
  "star"       NUMBER        NULL,
  "comment"    VARCHAR2(200) NULL,
  "created_by" VARCHAR2(36)  NULL,
  "created_at" TIMESTAMP     NULL,
  "updated_by" VARCHAR2(36)  NULL,
  "updated_at" TIMESTAMP     NULL,
  "user_id"    VARCHAR2(36)  NOT NULL,
  "user_name"  VARCHAR2(36)  NULL,
  PRIMARY KEY ("store_id", "sort", "user_id")
)
  NOCOMPRESS
  NOPARALLEL;