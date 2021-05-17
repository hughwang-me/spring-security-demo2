DROP TABLE IF EXISTS users;
CREATE TABLE users(
                      id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(20) UNIQUE NOT NULL,
                      password VARCHAR(100)
);

DELETE  FROM users;

INSERT INTO users (id, username, password) VALUES
(1, '张三', '123456'),
(2, '李四', '123456'),
(3, '王五', '123456');
