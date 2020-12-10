BEGIN TRANSACTION;

DROP TABLE IF EXISTS trades;
DROP TABLE IF EXISTS trade_types;
DROP TABLE IF EXISTS trade_statuses;
DROP TABLE IF EXISTS friends_list;
DROP TABLE IF EXISTS friend_request_statuses;
DROP TABLE IF EXISTS friend_request_types;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS users;


DROP SEQUENCE IF EXISTS seq_comic_id;
DROP SEQUENCE IF EXISTS seq_account_id;
DROP SEQUENCE IF EXISTS seq_collection_id;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_trade_id;
DROP SEQUENCE IF EXISTS seq_friends_list_id;
DROP SEQUENCE IF EXISTS seq_friend_request_status_id CASCADE;
DROP SEQUENCE IF EXISTS seq_friend_request_type_id CASCADE;
DROP SEQUENCE IF EXISTS seq_trade_type_id CASCADE;
DROP SEQUENCE IF EXISTS seq_trade_status_id CASCADE;


  
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_trade_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_trade_type_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_trade_status_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_friends_list_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_friend_request_status_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

  
CREATE SEQUENCE seq_friend_request_type_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
 
CREATE SEQUENCE seq_collection_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_comic_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE collections (
        collection_id int DEFAULT nextval('seq_collection_id'::regclass) NOT NULL,
        collection_name varchar (500) NOT NULL,
        collection_desc varchar (500),
        CONSTRAINT PK_collection_id PRIMARY KEY (collection_id)
);

CREATE TABLE comics (
        comic_id int DEFAULT nextval('seq_comic_id'::regclass) NOT NULL,
        comic_name varchar(500) NOT NULL,
        publisher_name varchar(500) NOT NULL,
        author_name varchar(500) NOT NULL,
        comic_type varchar(500) NOT NULL,
        date_published date NOT NULL,
        CONSTRAINT PK_comic_id PRIMARY KEY (comic_id)
       
);

CREATE TABLE accounts (
        account_id int DEFAULT nextval('seq_account_id'::regclass) NOT NULL,
        user_id int NOT NULL,
        comic_id int NOT NULL,
        collection_id int NOT NULL,
        account_type varchar(40) NOT NULL,
	CONSTRAINT PK_accounts PRIMARY KEY (account_id),
	CONSTRAINT FK_accounts_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_comic_id FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
	CONSTRAINT FK_collection_id FOREIGN KEY (collection_id) REFERENCES collections (collection_id)
);

CREATE TABLE trade_statuses (
	trade_status_id int DEFAULT nextval('seq_trade_status_id'::regclass) NOT NULL,
	trade_status_desc varchar(10) NOT NULL,
	CONSTRAINT PK_trade_statuses PRIMARY KEY (trade_status_id)
);

CREATE TABLE trade_types (
	trade_type_id int DEFAULT nextval('seq_trade_type_id'::regclass) NOT NULL,
	trade_type_desc varchar(10) NOT NULL,
	CONSTRAINT PK_trade_types PRIMARY KEY (trade_type_id)
);


CREATE TABLE trades (
        trade_id int DEFAULT nextval('seq_trade_id'::regclass) NOT NULL,
	trade_type_id int NOT NULL,
	trade_status_id int NOT NULL,
	account_from int NOT NULL,
	account_to int NOT NULL,
	comic_id int NOT NULL,
	CONSTRAINT PK_trades PRIMARY KEY (trade_id),
	CONSTRAINT FK_trades_account_from FOREIGN KEY (account_from) REFERENCES accounts (account_id),
	CONSTRAINT FK_trades_account_to FOREIGN KEY (account_to) REFERENCES accounts (account_id),
	CONSTRAINT FK_trades_trade_statuses FOREIGN KEY (trade_status_id) REFERENCES trade_statuses (trade_status_id),
	CONSTRAINT FK_trades_trade_types FOREIGN KEY (trade_type_id) REFERENCES trade_types (trade_type_id),
	CONSTRAINT CK_trades_not_same_account CHECK  ((account_from<>account_to))
);

CREATE TABLE friend_request_statuses (
	friend_request_status_id int DEFAULT nextval('seq_friend_request_status_id'::regclass) NOT NULL,
	friend_request_status_desc varchar(10) NOT NULL,
	CONSTRAINT PK_friends_request_statuses PRIMARY KEY (friend_request_status_id)
);
        
CREATE TABLE friend_request_types (
	friend_request_type_id int DEFAULT nextval('seq_friend_request_type_id'::regclass) NOT NULL,
	friend_request_type_desc varchar(10) NOT NULL,
	CONSTRAINT PK_friend_request_types PRIMARY KEY (friend_request_type_id)
);


CREATE TABLE friends_list (
        friend_list_id int DEFAULT nextval('seq_friends_list_id'::regclass) NOT NULL,
	friend_request_type_id int NOT NULL,
	friend_request_status_id int NOT NULL,
	user_from int NOT NULL,
	user_to int NOT NULL,
	CONSTRAINT PK_friends_list_id PRIMARY KEY (friend_list_id),
	CONSTRAINT FK_friends_list_user_from FOREIGN KEY (user_from) REFERENCES users (user_id),
	CONSTRAINT FK_friends_list_user_to FOREIGN KEY (user_to) REFERENCES users (user_id),
	CONSTRAINT FK_friends_request_statuses FOREIGN KEY (friend_request_status_id) REFERENCES friend_request_statuses (friend_request_status_id),
	CONSTRAINT FK_friends_request_types FOREIGN KEY (friend_request_type_id) REFERENCES friend_request_types (friend_request_type_id),
	CONSTRAINT CK_trades_not_same_account CHECK  ((user_from<>user_to))
);
        
INSERT INTO trade_statuses (trade_status_desc) VALUES ('Pending');
INSERT INTO trade_statuses (trade_status_desc) VALUES ('Approved');
INSERT INTO trade_statuses (trade_status_desc) VALUES ('Rejected');

INSERT INTO trade_types (trade_type_desc) VALUES ('Request');
INSERT INTO trade_types (trade_type_desc) VALUES ('Send');

        
INSERT INTO friend_request_statuses (friend_request_status_desc) VALUES ('Pending');
INSERT INTO friend_request_statuses (friend_request_status_desc) VALUES ('Approved');
INSERT INTO friend_request_statuses (friend_request_status_desc) VALUES ('Rejected');

INSERT INTO friend_request_types (friend_request_type_desc) VALUES ('Request');
INSERT INTO friend_request_types (friend_request_type_desc) VALUES ('Send');

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

--DUMMY DATA--
INSERT INTO collections (collection_id, collection_name, collection_desc) VALUES (DEFAULT, 'DUMMY', 'SOME DESCRIPTION');
INSERT INTO collections (collection_id, collection_name, collection_desc) VALUES (DEFAULT, 'MY COLLECTION', 'SOME DESCRIPTION');
INSERT INTO comics (comic_id, comic_name, publisher_name, author_name, comic_type, date_published) VALUES (DEFAULT, 'DUMMY MAN', 'SPARVEL', 'DUM DUM', 'ACTION', '12-10-2020');
INSERT INTO comics (comic_id, comic_name, publisher_name, author_name, comic_type, date_published) VALUES (DEFAULT, 'RONA MAN', 'CDC COMICS', 'RORO', 'MYSTERY', '12-10-2020');
INSERT INTO accounts (account_id, user_id, comic_id, collection_id, account_type) VALUES (DEFAULT, '2', '1', '1', 'STANDARD');
INSERT INTO accounts (account_id, user_id, comic_id, collection_id, account_type) VALUES (DEFAULT, '2', '2', '2', 'PREMIUM');
INSERT INTO trades (trade_id, trade_type_id, trade_status_id, account_from, account_to, comic_id) VALUES (DEFAULT, '1', '2', '1', '2', '1');
-----------------
---Testing Query Searches---
        --getAllCollectionsByUserId--
        --SELECT collection_id, collection_name, collection_desc
        --FROM collections
        --INNER JOIN accounts USING (collection_id)
        --INNER JOIN users USING (user_id)
        --WHERE user_id = 1;
-------------------
COMMIT TRANSACTION;
