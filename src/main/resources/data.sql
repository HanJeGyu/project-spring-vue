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
insert into jobseekers(seeker_id,seeker_Name,password,birth_6,phone,email,industry,location) values ('han','kimid','1234','950117','01076794338','abc@gmail.com','웹프로그래머','서울');
/* insert into jobseekers(seeker_id,seeker_Name,password,birth_6,phone,email,industry,location) values ('han2','kim2','1234','950117','01076794338','abc@gmail.com','웹프로그래머','서울');
insert into jobseekers(seeker_id,seeker_Name,password,birth_6,phone,email,industry,location) values ('han3','kim3','1234','950117','01076794338','abc@gmail.com','웹프로그래머','서울');
insert into jobseekers(seeker_id,seeker_Name,password,birth_6,phone,email,industry,location) values ('han4','kim4','1234','950117','01076794338','abc@gmail.com','웹프로그래머','서울');
insert into jobseekers(seeker_id,seeker_Name,password,birth_6,phone,email,industry,location) values ('han5','kim5','1234','950117','01076794338','abc@gmail.com','웹프로그래머','서울');
 */commit;