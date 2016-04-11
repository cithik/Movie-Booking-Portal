package com.me.moviebooking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.moviebooking.model.BookingHistory;
import com.me.moviebooking.model.Cinema;
import com.me.moviebooking.model.Customer;


public class CustomerDAO extends DAO {
	public Customer isValidCustomer(String userName, String password)
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Customer where user_name = :name and password = :password");
			q.setString("name", userName);
			q.setString("password", password);
			Customer customer = (Customer) q.uniqueResult();
			return customer;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + userName, e);
		}
	}
	public List<BookingHistory> getBookingHistory(Integer personId) throws Exception{
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from BookingHistory where person_id =:person_id");
			q.setInteger("person_id", personId);
			List<BookingHistory> bookingHistory = (List<BookingHistory>) q.list();

			return bookingHistory;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public BookingHistory getBooking(Integer bookingId) throws Exception{
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from BookingHistory where booking_id =:bookingId");
			q.setInteger("bookingId", bookingId);
			BookingHistory bookingHistory = (BookingHistory) q.uniqueResult();
			return bookingHistory;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + e);
		}
	}
	public Customer getCustomer(String customerName)
			throws Exception {
		Query q;
		try {
			q = getSession()
					.createQuery(
							"from Customer where userName = :customerName");
			q.setString("customerName", customerName);
			Customer customer = (Customer) q.uniqueResult();
			return customer;
		} catch (HibernateException e) {
			throw new Exception("Could execute query " + customerName, e);
		}
	}
	public boolean createCustomer(Customer customer){
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(customer);
	        session.getTransaction().commit();
	        return true;
		} catch (HibernateException e) {
			System.out.println("Could execute query " + e);
		}
		return false;
	}
}
