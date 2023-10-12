package ca.sheridancollege.ostrovsr.beans;

import java.io.Serializable;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	private int restaurantId;
	private Double rating;
	private String reviewText;
	private String dateTimeUploaded;
	private String restaurantName;

}
