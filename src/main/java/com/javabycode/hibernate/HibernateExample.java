package com.javabycode.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import com.javabycode.hibernate.model.Student;
import com.javabycode.hibernate.model.Tenant;
import com.javabycode.hibernate.model.Apartment;
import com.javabycode.hibernate.model.ClassRoom;

public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Tenant tenant = new Tenant();
		Apartment apartment = new Apartment();
		tenant.setApartment(apartment);
		List<Tenant> tenants = new ArrayList<Tenant>();
		tenants.add(tenant);
		apartment.setTenants(tenants);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(apartment);
		session.getTransaction().commit();
		
		session.close();
	}

}
