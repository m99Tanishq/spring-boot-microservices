DROP TABLE IF EXISTS t_orders;
CREATE TABLE IF NOT EXISTS t_orders (
                          `id` BIGINT NOT NULL AUTO_INCREMENT,
                          `order_number` VARCHAR(40) NULL,
                          `sku_code` VARCHAR(255),
                          `price` DECIMAL(19, 2),
                          `quantity` INT,
                          PRIMARY KEY (`id`)
);