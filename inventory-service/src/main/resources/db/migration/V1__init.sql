DROP TABLE IF EXISTS t_inventory;
CREATE TABLE IF NOT EXISTS t_inventory (
                                        `id` BIGINT NOT NULL AUTO_INCREMENT,
                                        `sku_code` VARCHAR(255),
                                        `quantity` INT,
                                        PRIMARY KEY (`id`)
);