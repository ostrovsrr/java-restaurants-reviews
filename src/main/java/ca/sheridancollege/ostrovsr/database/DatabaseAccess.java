package ca.sheridancollege.ostrovsr.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ostrovsr.beans.Restaurant;
import ca.sheridancollege.ostrovsr.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;


	public void addReview(Review review) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("restaurantId", review.getRestaurantId());
		parameters.addValue("rating", review.getRating());
		parameters.addValue("reviewText", review.getReviewText());

		String query = "INSERT INTO reviews (restaurantId, rating, reviewText) VALUES (:restaurantId, :rating, :reviewText)";
		jdbc.update(query, parameters);
		

	}

	public ArrayList<Restaurant> getRestaurants() {
		String q = "SELECT * from restaurants";
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) jdbc.query(q,
				new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
		return restaurants;
	}

	public ArrayList<Review> getReviews() {
		String q = "SELECT reviewId, reviews.restaurantId, rating, reviewText, dateTimeUploaded, restaurantName FROM reviews JOIN restaurants ON restaurants.restaurantId = reviews.restaurantId";
		ArrayList<Review> reviews = (ArrayList<Review>) jdbc.query(q, new BeanPropertyRowMapper<Review>(Review.class));
		return reviews;
	}

}
