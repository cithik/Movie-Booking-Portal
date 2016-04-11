package com.me.moviebooking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.moviebooking.model.BookingHistory;
import com.me.moviebooking.model.Cinema;
import com.me.moviebooking.model.Customer;
import com.me.moviebooking.model.Movie;
import com.me.moviebooking.model.MovieComment;
import com.me.moviebooking.model.ScreenComment;
import com.me.moviebooking.model.Showtime;
import com.me.moviebooking.model.UserPreferences;


public class MovieDAO extends DAO {
	public List<Movie> getMovies()
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Movie");
			List<Movie> movies = (List<Movie>) q.list();
			return movies;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public List<Showtime> getShowTimes()
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Showtime");
			List<Showtime> showtimes = (List<Showtime>) q.list();
			return showtimes;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public List<MovieComment> getMovieComments()
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from MovieComment");
			List<MovieComment> comments = (List<MovieComment>) q.list();
			return comments;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public List<Cinema> getCinemas()
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Cinemas");
			List<Cinema> cinemas = (List<Cinema>) q.list();
			return cinemas;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public Showtime getBookingShow(UserPreferences up)
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Showtime where movie_id = :movieId "
							+ "and screen_id = :screenId and "
							+ "cinema_id = :cinemaId and time= :time");
			q.setInteger("movieId", up.getMovieId());
			q.setInteger("screenId", up.getScreenId());
			q.setInteger("cinemaId", up.getCinemaId());
			q.setString("time", up.getTime());
			Showtime showtime = (Showtime) q.uniqueResult();
			return showtime;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public boolean createHistory(BookingHistory bh){
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(bh);
	        session.getTransaction().commit();
	        return true;
		} catch (HibernateException e) {
			System.out.println("Could execute query " + e);
		}
		return false;
	}
	public boolean rateScreen(ScreenComment sc){
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(sc);
	        session.getTransaction().commit();
	        return true;
		} catch (HibernateException e) {
			System.out.println("Could execute query " + e);
		}
		return false;
	}
	public boolean rateMovie(MovieComment mc){
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(mc);
	        session.getTransaction().commit();
	        return true;
		} catch (HibernateException e) {
			System.out.println("Could execute query " + e);
		}
		return false;
	}
}
