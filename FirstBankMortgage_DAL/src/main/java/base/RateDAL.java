package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {

	public static ArrayList<RateDomainModel> getRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;	
		ArrayList<RateDomainModel> Rates = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List rates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = rates.iterator(); iterator.hasNext();) {
				RateDomainModel r = (RateDomainModel)iterator.next();
				Rates.add(r);
			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Rates;
	}
	
	
	
	
	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		double rate = 0;
		try {
			tx = session.beginTransaction();
			int credScore = GivenCreditScore;
		if (GivenCreditScore >= 800) {
			 getInterestRate(3.5);}
		else if (GivenCreditScore >=750)
		{getInterestRate(3.75);}
		else if (GivenCreditScore >=700)
		{getInterestRate(4.0);}
		else if (GivenCreditScore >=650)
		{getInterestRate(4.5);}
		else  if (GivenCreditScore >=600)
		{getInterestRate(5.0);}
		
		else {
			System.out.println("Interest rate  " +GivenCreditScore+ " not in database." );
			credScore = 600;
		}
		String sql = new String("Select InterestRate, min credit score = " +credScore);
		Query rateQuery = session.createQuery(sql);
		List rates = rateQuery.list();
		rate = (Double)rates.get(0);
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rate;
	}
	



	private static void getInterestRate(double d) {
		// TODO Auto-generated method stub
		
	}



}
