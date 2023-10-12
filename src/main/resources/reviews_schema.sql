CREATE TABLE restaurants(
	restaurantId INT PRIMARY KEY AUTO_INCREMENT,
    restaurantName VARCHAR(50) NOT NULL
);

CREATE TABLE reviews(
    reviewId INT PRIMARY KEY AUTO_INCREMENT,
    restaurantId INT NOT NULL,
    rating DECIMAL(2, 1) NOT NULL,
    reviewText VARCHAR(300) NOT NULL,
    dateTimeUploaded TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (restaurantId) REFERENCES restaurants(restaurantId)
);
