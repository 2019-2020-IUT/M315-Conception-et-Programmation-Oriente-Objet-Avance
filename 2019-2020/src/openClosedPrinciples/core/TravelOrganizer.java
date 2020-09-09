package openClosedPrinciples.core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TravelOrganizer {
	List<FlightService> airlinesCompanies; 
	List<CarRentalService> carRentCompanies; 
	
	/// Constructeurs 
	
	public TravelOrganizer() {
		airlinesCompanies = new ArrayList<>(); 
		carRentCompanies = new ArrayList<>(); 
	}
	
	
	/// Accesseurs et mutateurs 

	public List<FlightService> getAirlinesCompanies() {
		return airlinesCompanies;
	}

	public void setAirlinesCompanies(List<FlightService> airlinesCompanies) {
		this.airlinesCompanies = airlinesCompanies;
	}


	public List<CarRentalService> getCarRentCompanies() {
		return carRentCompanies;
	}


	public void setCarRentCompanies(List<CarRentalService> carRentCompanies) {
		this.carRentCompanies = carRentCompanies;
	}
	
	
	/// Méthodes 
	
	// Ajouter une compagnie aérienne 
	public void addAirlineCompany(FlightService company) {
		airlinesCompanies.add(company);
	}
	
	// Ajouter une compagnie de location de voitures 
	public void addCarRentCompany(CarRentalService company) {
		carRentCompanies.add(company);
	}
	
	// Créer un voyage 
	public Trip createATrip(Description description) throws AucunItemCorrespondant {
		Trip t = new Trip(description); 
		Flight f = this.findFlight(description); 
		CarRental cr = this.findCar(description); 
		if(f!=null && cr!=null) {
			t.addItem(f);
			t.addItem(cr);
		}else {
			throw new AucunItemCorrespondant("Aucun voyage ne correspond aux critères recherchés.");
		}
		return t; 
	}
	
	// Recherche un vol 
	public Flight findFlight(Description description) throws AucunItemCorrespondant {
		List<Flight> flights = new ArrayList(); 
		for(FlightService fs : airlinesCompanies) {
			Flight f = fs.find(description); 
			if(f != null)
				flights.add(f); 
		}
		flights.sort(Comparator.comparing(Flight::getPrice));
		if(flights.isEmpty()) {
			throw new AucunItemCorrespondant("Aucun vol correspondant à votre recherche."); 
		}
		return flights.get(0); 
	}
	
	// Recherche une voiture 
	public CarRental findCar(Description description) throws AucunItemCorrespondant {
		List<CarRental> cars = new ArrayList(); 
		for(CarRentalService c : carRentCompanies) {
			CarRental cr = c.find(description); 
			if(cr!=null)
				cars.add(cr); 
		}
		cars.sort(Comparator.comparing(CarRental::getPrice));
		if(cars.isEmpty()) {
			throw new AucunItemCorrespondant("Aucune location de voiture correspondant à votre recherche."); 
		}
		return cars.get(0); 
	}
}
