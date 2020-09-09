package openClosedPrinciples.core;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import openClosedPrinciples.core.Flight;
import openClosedPrinciples.core.FlightService;

public class FlightServiceTest {

	FlightService service ;
	@Before
	public void setUp() throws Exception {
		ArrayList<Flight> list = new ArrayList<>();
		list.add(new Flight("Belfort"));
		list.add(new Flight("Nice"));
		list.add(new Flight(100, LocalDate.of(2017, 12, 24), LocalTime.of(7, 45),"Nice", "Paris"));
		list.add(new Flight(150, LocalDate.of(2017, 12, 24), LocalTime.of(9, 30), "Nice", "Paris"));
		list.add(new Flight(150, LocalDate.of(2017, 12, 24), LocalTime.of(18, 30), "Paris", "Nice"));
		service = new FlightService(list);
	}


	@Test
	public void testGetFlightsOnADivenDate() {
		List<Flight> flights = service.getFlights(LocalDate.now());
		assertEquals(2, flights.size());
		flights = service.getFlights(LocalDate.of(2017, 12, 24));
		assertEquals(3, flights.size());
	}

	@Test
	public void testGetFlights() {
		List<Flight> flights = service.getFlights(LocalDate.now(),"Nice","Paris");
		assertEquals(1, flights.size());
		flights = service.getFlights(LocalDate.of(2017, 12, 24),"Nice","Paris");
		assertEquals(2, flights.size());
	}

}
