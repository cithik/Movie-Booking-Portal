package com.me.moviebooking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.moviebooking.dao.CustomerDAO;
import com.me.moviebooking.dao.MovieDAO;
import com.me.moviebooking.model.BookingHistory;
import com.me.moviebooking.model.BookingRating;
import com.me.moviebooking.model.BookingSelection;
import com.me.moviebooking.model.Customer;
import com.me.moviebooking.model.MovieComment;
import com.me.moviebooking.model.MoviePrefs;
import com.me.moviebooking.model.ScreenComment;
import com.me.moviebooking.model.Showtime;
import com.me.moviebooking.model.UserPreferences;
import com.me.moviebooking.validator.CustomerValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Autowired
	private MovieDAO movieDao;
	
	@Autowired
    @Qualifier("customerValidator")
    private Validator validator;
 
    @InitBinder("customerLogin")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
//    @ModelAttribute("customer")
//    public Customer createEmployeeModel() {
//        return new Customer();
//    }
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		logger.info("First Page sucessfully called.!");
		Customer customer = new Customer();
		model.addAttribute("customerLogin", customer);
		return "login";
	}
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String validate(Model model, @Valid @ModelAttribute("customerLogin") Customer customer,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		logger.info("Validation Page.!");
		if (result.hasErrors()) {
            logger.info("Returning custSave.jsp page");
            return "login";
        }
		Customer customerFromDb = customerDao.isValidCustomer(customer.getUserName(),
				customer.getPassword());
		if(customerFromDb!=null){
			logger.info(customerFromDb.getUserName());
			model.addAttribute("customer", customerFromDb);
			return "home";
		}else{
			return "login";
		}
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registartion(Model model,
			HttpServletRequest request) throws Exception {
		logger.info("Registration Page.!");
		model.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String login(Model model, @Valid @ModelAttribute("customer") Customer customer,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) {
		if (result.hasErrors()) {
            logger.info("Returning to registration.jsp page");
            return "registration";
        }
		try{
		customerDao.createCustomer(customer);
		}catch(ConstraintViolationException cve){
			logger.info("Returning exception registration.jsp"+cve);
            return "registration";
		}
		model.addAttribute("customerLogin", customer);
		return "login";
	}
	
	@RequestMapping(value = "/selectmovie", method = RequestMethod.POST)
	public String booking(Model model, @ModelAttribute("customer") Customer customer,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		logger.info("Booking Page.!");
		List<Showtime> showtimes = movieDao.getShowTimes();
		MoviePrefs mp = new MoviePrefs(customer.getUserName(),
				showtimes, new UserPreferences());
		model.addAttribute("mp", mp);
		return "booking";
	}
	
	@RequestMapping(value = "/booktickets", method = RequestMethod.POST)
	public String showScreens(Model model, @ModelAttribute("mp") MoviePrefs mp,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		logger.info("Screens Page.!");
		Showtime showtime = movieDao.getBookingShow(mp.getUp());
		Customer customer = customerDao.getCustomer(mp.getUserName());
		logger.info(mp.getUserName().toString());
		logger.info(customer.getUserName());
		model.addAttribute("bs", new BookingSelection(customer,
				showtime, 0, 0));
		return "tickets";
	}
	@RequestMapping(value = "/booked", method = RequestMethod.POST)
	public String booked(Model model,  @ModelAttribute("bs") BookingSelection bs,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		BookingHistory bh = new BookingHistory();
		Showtime st = new Showtime();
		logger.info(bs.getCustomer().getUserName());
		Customer customer = customerDao.getCustomer(bs.getCustomer().getUserName());
		model.addAttribute("customer", customer);
		st.setShowtimeId(bs.getShowtime().getShowtimeId());
		bh.setShowtime(st);
		bh.setQuantity(bs.getQuantity());
		bh.setCustomer(customer);
		movieDao.createHistory(bh);
		logger.info("booked Page.!");
		if (result.hasErrors()) {
            logger.info("Returning registration.jsp page");
            return "booking";
        }
		return "home";
	}
	
	@RequestMapping("/history/{personId}")
    public String detail(@PathVariable(value = "personId") Integer personId, ModelMap model)
    		throws Exception {
		List< BookingHistory> bookingHistory = customerDao.getBookingHistory(personId);
        model.put("bookings", bookingHistory);
        return "history";
    }
	@RequestMapping(value = "/rateBooking", method = RequestMethod.POST)
	public String rateBooking(Model model,  @ModelAttribute("customer") Customer customer,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		logger.info("Rate Booking-"+ customer.getPersonId());
		List< BookingHistory> bookingHistory = customerDao.getBookingHistory(customer.getPersonId());
		model.addAttribute("booking", bookingHistory);
		model.addAttribute("bookingRating", new BookingRating());
		return "rating";
	}
	@RequestMapping(value = "/rated", method = RequestMethod.POST)
	public String rated(Model model,  @ModelAttribute("bookingRating") BookingRating bookingRating,
			BindingResult result, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		BookingHistory bookingHistory = customerDao.getBooking(bookingRating.getBookingId());
		logger.info("Rate Booking-"+ bookingHistory.getBookingId().toString());
		MovieComment mc = new MovieComment();
		mc.setBookingId(bookingHistory.getBookingId());
		mc.setBookingHistory(bookingHistory);
		mc.setComment(bookingRating.getMovieComment());
		mc.setRating(bookingRating.getMovieRating());
		movieDao.rateMovie(mc);
		ScreenComment sc = new ScreenComment();
		sc.setBookingId(bookingHistory.getBookingId());
		sc.setBookingHistory(bookingHistory);
		sc.setComment(bookingRating.getMovieComment());
		sc.setRating(bookingRating.getMovieRating());
		movieDao.rateScreen(sc);
		model.addAttribute("customer", bookingHistory.getCustomer());
		return "home";
	}
	
	@RequestMapping(value = "/movieRating", method = RequestMethod.POST)
    public String index(@ModelAttribute("model") ModelMap model) {
		List<MovieComment> comments;
		try {
			comments = movieDao.getMovieComments();
			model.addAttribute("comments", comments);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "moviecomments";
    }
}
