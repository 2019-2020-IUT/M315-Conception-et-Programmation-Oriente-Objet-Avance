package openClosedPrinciples.core;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import openClosedPrinciples.core.Car;
import openClosedPrinciples.core.CarRental;
import openClosedPrinciples.core.CarRentalService;
import openClosedPrinciples.core.NotPossibleCarRentalException;


public class CarRentalServiceTest {

	CarRentalService service ; 
	Car myCar0 = new Car("1111 AB 06",50);
	Car myCar1 = new Car("1111 AB 75",100);
	Car myCar2 = new Car("1111 AB 83",75);
	LocalDate currentDate;
	
	@Before
	public void setUp() throws Exception {
		 myCar0 = new Car("1111 AB 06",50);
		 myCar1 = new Car("1111 AB 75",100);
		 myCar2 = new Car("1111 AB 83",75);
		service = new CarRentalService( new ArrayList<>(Arrays.asList(myCar0, myCar1, myCar2) )  )  ;
		
	}

	@Test
	public void testGetAvailableCars() {
		ArrayList<Car> possibleCars = 
				(ArrayList<Car>) service.getAvailableCars(LocalDate.of(2018,9,11), 2);
		assertEquals(3, possibleCars.size());
	}
	
	
	@Test
	public void testBookAnAvalaibleCar() throws NotPossibleCarRentalException {
		CarRental carRental = service.book(myCar0,LocalDate.of(2018,9,11), 2);
		assertFalse(carRental==null);
		List<Car> possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,11), 1);
		assertEquals(2, possibleCars.size());

		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,12), 3);
		assertEquals(2, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,13), 3);
		assertEquals(3, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,9), 4);
		assertEquals(2, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,19), 7);
		assertEquals(3, possibleCars.size());
		
	}
	
	
	@Test
	public void testBookANonAvalaibleCar() throws NotPossibleCarRentalException {
		CarRental carRental = service.book(myCar0,LocalDate.of(2017,9,11), 2);
		assertFalse(carRental==null);
		carRental = service.book(myCar0,LocalDate.of(2017,9,12), 2);
		assertTrue(carRental==null);
	}
	
	@Test
	public void testGetNotAvailableCars() throws NotPossibleCarRentalException {
		service.book(myCar0,LocalDate.of(2017,9,11), 2);
		List<Car> possibleCars = service.getAvailableCars(LocalDate.of(2017,9,11), 2);
		assertEquals(2, possibleCars.size());
		possibleCars = service.getAvailableCars(LocalDate.of(2017,9,12), 2);
		assertEquals(2, possibleCars.size());
		possibleCars = service.getAvailableCars(LocalDate.of(2017,9,13), 2);
		assertEquals(3, possibleCars.size());
	}



}
