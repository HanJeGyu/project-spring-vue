DROP TABLE IF EXISTS jobseekers;
CREATE TABLE jobseekers (
id INT AUTO_INCREMENT PRIMARY KEY,
seeker_id VARCHAR(15) UNIQUE NOT NULL,
seeker_Name VARCHAR(15) NOT NULL,
PASSWORD VARCHAR(50) NOT NULL,
birth_6 VARCHAR(6) NOT NULL,
phone VARCHAR(13) NOT NULL,
email VARCHAR(50) NOT NULL,
industry VARCHAR(200),
location VARCHAR(200)
)DEFAULT CHARSET=utf8;
/* insert into customers(customer_id,customer_name,password,ssn,phone,city,address,postalcode) values ('haha','changha kim','1234','950117-1622514','01076794338','광주광역시 광산구 사암로 306(월곡동)','금호아파트 13동408호','62347');
insert into customers(customer_id,customer_name,password,ssn,phone,city,address,postalcode) values ('hoho','이규진','1234','910512-162513','010-4745-2222','서울특별시 성북구 화랑로 140-1(하월곡동)','한성아파트 104동101호','02793');
 */commit;