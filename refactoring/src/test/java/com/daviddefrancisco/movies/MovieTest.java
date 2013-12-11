package com.daviddefrancisco.movies;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

	Customer aCustomer;
	Movie inception, oblivium, godfather, memento, aladdin, brave;
	Rental inceptionRental, obliviumRental, godfatherRental, mementoRental, aladdinRental, braveRental;
	
	public MovieTest() {
		inception 	= new Movie("Inception", Movie.NEW_RELEASE);
		oblivium 	= new Movie("Oblivium", Movie.NEW_RELEASE);
		godfather	= new Movie("The Godfather", Movie.REGULAR);
		memento		= new Movie("Memento", Movie.REGULAR);
		aladdin		= new Movie("Aladdin", Movie.CHILDRENS);
		brave		= new Movie("Brave", Movie.CHILDRENS);
		
		inceptionRental		= new Rental(inception, 1);
		obliviumRental		= new Rental(oblivium, 3);
		godfatherRental		= new Rental(godfather, 1);
		mementoRental		= new Rental(memento, 3);
		aladdinRental		= new Rental(aladdin, 3);
		braveRental			= new Rental(brave, 5);
	}
	
	@Before
	public void customerInitialization() {
		aCustomer = new Customer("John");
	}
	
	@Test
	public void shortNewReleaseRentalTest() {
		aCustomer.addRental(inceptionRental);
		assertStatement(3, 1);
	}
	
	@Test
	public void longNewReleaseRentalTest() {
		aCustomer.addRental(obliviumRental);
		assertStatement(9, 2);
	}
	
	@Test
	public void shortRegularRentalTest() {
		aCustomer.addRental(godfatherRental);
		assertStatement(2, 1);
	}
	
	@Test
	public void longRegularRentalTest() {
		aCustomer.addRental(mementoRental);
		assertStatement(3.5, 1);
	}
	
	@Test
	public void shortChildrenRentalTest() {
		aCustomer.addRental(aladdinRental);
		assertStatement(1.5, 1);
	}
	
	@Test
	public void longChildrenRentalTest() {
		aCustomer.addRental(braveRental);
		assertStatement(4.5, 1);
	}
	
	private void assertStatement(double amount, int points) {
		assert aCustomer.statement().contains("Amount owed is " + String.valueOf(amount));
		assert aCustomer.statement().contains("You earned " + String.valueOf(points));
		assert aCustomer.htmlStatement().contains("owe <EM>" + String.valueOf(amount));
		assert aCustomer.htmlStatement().contains("you earned <EM>" + String.valueOf(points));		
	}
}
