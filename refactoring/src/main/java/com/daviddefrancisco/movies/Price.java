package com.daviddefrancisco.movies;

public abstract class Price {
	abstract int getPriceCode();	
	abstract double getCharge(int daysRented);	
	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}	