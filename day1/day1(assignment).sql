Last login: Wed Jul  1 10:11:26 on ttys000
satvikaharivanam@Satvikas-MacBook-Air ~ % mysql -u root
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
Server version: 9.7.1 Homebrew

Copyright (c) 2000, 2026, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> create database school;
Query OK, 1 row affected (0.005 sec)

mysql> use database school;
ERROR 1049 (42000): Unknown database 'database'
mysql> use school;
Database changed
mysql> create table students (studentid int primary key, name varchar(50), age int, gender varchar(10), city varchar(50));
Query OK, 0 rows affected (0.012 sec)

mysql> insert into students (101, 'rahul', 20, 'male', 'hyderabad');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '101, 'rahul', 20, 'male', 'hyderabad')' at line 1
mysql> insert into students values (101, 'rahul', 20, 'male', 'hyderabad');
Query OK, 1 row affected (0.003 sec)

mysql> insert into students values (102, 'priya', 19, 'female', 'chennai');
Query OK, 1 row affected (0.002 sec)

mysql> insert into students values (103, 'arjun',21, 'male', 'bengaluru');
Query OK, 1 row affected (0.001 sec)

mysql> insert into students values (104, 'sneha',20, 'female', 'mumbai');
Query OK, 1 row affected (0.001 sec)

mysql> insert into students values (105, 'kiran',22, 'male', 'pune');
Query OK, 1 row affected (0.002 sec)

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | hyderabad |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   21 | male   | bengaluru |
|       104 | sneha |   20 | female | mumbai    |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
5 rows in set (0.000 sec)

mysql> select name, city from students;
+-------+-----------+
| name  | city      |
+-------+-----------+
| rahul | hyderabad |
| priya | chennai   |
| arjun | bengaluru |
| sneha | mumbai    |
| kiran | pune      |
+-------+-----------+
5 rows in set (0.002 sec)

mysql> select * from students where age > 20;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       103 | arjun |   21 | male   | bengaluru |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
2 rows in set (0.000 sec)

mysql> select * from students where gender like 'f%';
+-----------+-------+------+--------+---------+
| studentid | name  | age  | gender | city    |
+-----------+-------+------+--------+---------+
|       102 | priya |   19 | female | chennai |
|       104 | sneha |   20 | female | mumbai  |
+-----------+-------+------+--------+---------+
2 rows in set (0.002 sec)

mysql> select * from students where city = 'hyderabad';
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | hyderabad |
+-----------+-------+------+--------+-----------+
1 row in set (0.000 sec)

mysql> select * from students order by name aesc;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'aesc' at line 1
mysql> select * from students order by name asc;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       103 | arjun |   21 | male   | bengaluru |
|       105 | kiran |   22 | male   | pune      |
|       102 | priya |   19 | female | chennai   |
|       101 | rahul |   20 | male   | hyderabad |
|       104 | sneha |   20 | female | mumbai    |
+-----------+-------+------+--------+-----------+
5 rows in set (0.002 sec)

mysql> select * from students order by age desc;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       105 | kiran |   22 | male   | pune      |
|       103 | arjun |   21 | male   | bengaluru |
|       101 | rahul |   20 | male   | hyderabad |
|       104 | sneha |   20 | female | mumbai    |
|       102 | priya |   19 | female | chennai   |
+-----------+-------+------+--------+-----------+
5 rows in set (0.001 sec)

mysql> select * from students order by city, name;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       103 | arjun |   21 | male   | bengaluru |
|       102 | priya |   19 | female | chennai   |
|       101 | rahul |   20 | male   | hyderabad |
|       104 | sneha |   20 | female | mumbai    |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
5 rows in set (0.001 sec)

mysql> select * from students where age between 19 and 21;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | hyderabad |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   21 | male   | bengaluru |
|       104 | sneha |   20 | female | mumbai    |
+-----------+-------+------+--------+-----------+
4 rows in set (0.001 sec)

mysql> select * from students where name like 'r%';
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | hyderabad |
+-----------+-------+------+--------+-----------+
1 row in set (0.000 sec)

mysql> select * from students where age in (20,22);
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | hyderabad |
|       104 | sneha |   20 | female | mumbai    |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
3 rows in set (0.003 sec)

mysql> update students city = 'delhi' where name = 'rahul';
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '= 'delhi' where name = 'rahul'' at line 1
mysql> update students set city = 'delhi' where name = 'rahul';
Query OK, 1 row affected (0.010 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | delhi     |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   21 | male   | bengaluru |
|       104 | sneha |   20 | female | mumbai    |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
5 rows in set (0.000 sec)

mysql> update students set age = age+1 where name = 'arjun';
Query OK, 1 row affected (0.004 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | delhi     |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   22 | male   | bengaluru |
|       104 | sneha |   20 | female | mumbai    |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
5 rows in set (0.000 sec)

mysql> update students set city = 'kolkata' where name = 'sneha';
Query OK, 1 row affected (0.002 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | delhi     |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   22 | male   | bengaluru |
|       104 | sneha |   20 | female | kolkata   |
|       105 | kiran |   22 | male   | pune      |
+-----------+-------+------+--------+-----------+
5 rows in set (0.000 sec)

mysql> delete from students where studentid = 105;
Query OK, 1 row affected (0.003 sec)

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | delhi     |
|       102 | priya |   19 | female | chennai   |
|       103 | arjun |   22 | male   | bengaluru |
|       104 | sneha |   20 | female | kolkata   |
+-----------+-------+------+--------+-----------+
4 rows in set (0.000 sec)

mysql> delete from students where city ='chennai';
Query OK, 1 row affected (0.001 sec)

mysql> select * from students;
+-----------+-------+------+--------+-----------+
| studentid | name  | age  | gender | city      |
+-----------+-------+------+--------+-----------+
|       101 | rahul |   20 | male   | delhi     |
|       103 | arjun |   22 | male   | bengaluru |
|       104 | sneha |   20 | female | kolkata   |
+-----------+-------+------+--------+-----------+
3 rows in set (0.000 sec)

mysql> 
