package ca.sheridancollege.ostrovsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.ostrovsr.beans.Review;
import ca.sheridancollege.ostrovsr.database.DatabaseAccess;

@Controller
public class MainController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/add")
	public String addReview(Model model) {
		model.addAttribute("review", new Review());
		model.addAttribute("restaurants", da.getRestaurants());
		return "addReview";
	}
	
	@PostMapping("/")
	public String post(@ModelAttribute Review review) {
		System.out.println(review);
		da.addReview(review);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String viewReviews(Model model) {
//		model.addAttribute("restaurants", da.getRestaurants());
		model.addAttribute("reviews", da.getReviews());
		return "index";
	}
	
	
	

}
