package com.microservice.user.service.ServiceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.service.Repository.UserRepository;
import com.microservice.user.service.Services.UserService;
import com.microservice.user.service.entity.Hotel;
import com.microservice.user.service.entity.Rating;
import com.microservice.user.service.entity.User;
import com.microservice.user.service.exception.ResourceNotFoundException;
import com.microservice.user.service.external.service.HotelService;
import com.microservice.user.service.external.service.RatingService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	//@Autowired
	//private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;

	// private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public User getUser(String id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found on server."));

		// get user rating
		//using RestTemplate
		//Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + user.getId(),Rating[].class);
		//List<Rating> userRatings = Arrays.stream(ratings).toList();
		
		//using Feign Client
		List<Rating> ratings = ratingService.getRatings(user.getId());

		// get hotel by hotel Id from rating
		List<Rating> ratingList = ratings.stream().map(rating -> {
			//Using RestTemplate
			// ResponseEntity<Hotel> forEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
			// Hotel hotel = forEntity.getBody();

			// Using Feign Client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
