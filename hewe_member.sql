DROP DATABASE IF EXISTS hewe_member;
CREATE DATABASE hewe_member
  CHARACTER SET utf8;

#member表
DROP TABLE IF EXISTS hewe_member.member;
CREATE TABLE hewe_member.`member`
(
  id     VARCHAR(50) PRIMARY KEY,
  cel    VARCHAR(20),
  email  VARCHAR(20),
  passwd VARCHAR(50)
);
#mprofile表
DROP TABLE IF EXISTS hewe_member.mprofile;
CREATE TABLE hewe_member.`mprofile`
(
  id   VARCHAR(50) PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  bth  DATE        NOT NULL,
  sex  INT         NOT NULL
);
