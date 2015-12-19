package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	
	public double getPayment(int NumberOfPayments, int years, int amt)
	{
		 
			
				int y = years * 12;
				
					double interestrate = RateDAL.getRate(getMinCreditScore());
					double monthly = -1*FinanceLib.pmt(interestrate/1200, y, amt, 0, false);
					
					
					return monthly;
				}
}
