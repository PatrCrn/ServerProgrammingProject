CREATE TABLE IF NOT EXISTS user (
    user_id int(5) NOT NULL AUTO_INCREMENT,
    user_username varchar(50) DEFAULT NULL,
    user_password varchar(64) DEFAULT NULL,
    user_email varchar(50) DEFAULT NULL,
    user_role varchar(50) DEFAULT NULL,
    UNIQUE(user_username),
    PRIMARY KEY(user_id)
    );

CREATE TABLE IF NOT EXISTS cryptocurrency (
    crypto_id int(5) NOT NULL AUTO_INCREMENT,
    crypto_name varchar(50) DEFAULT NULL,
    crypto_ticker varchar(10) DEFAULT NULL,
    crypto_date timestamp DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(crypto_ticker),
    PRIMARY KEY(crypto_id)
    );

CREATE TABLE IF NOT EXISTS trade (
    trade_id int(5) NOT NULL AUTO_INCREMENT,
    trade_day int(2) DEFAULT NULL,
    trade_month varchar(16) DEFAULT NULL,
    trade_year int(4) DEFAULT NULL,
    trade_amount int(16) DEFAULT NULL,
    trade_entry float(30) DEFAULT NULL,
    trade_exit float(30) DEFAULT NULL,
    trade_crypto_id int(5) DEFAULT NULL,
    FOREIGN KEY (trade_crypto_id) REFERENCES cryptocurrency(crypto_id) ON DELETE CASCADE,
    PRIMARY KEY(trade_id)
    );