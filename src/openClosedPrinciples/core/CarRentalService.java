package openClosedPrinciples.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mireille Blay-Fornarino
 *
 * 6 oct. 2018
 */
public class CarRentalService extends Service<CarRental> {
	private ArrayList<Car> cars;
	
	
	/// Constructeurs 
	
	public CarRentalService(ArrayList<Car> cars) {
		super(new ArrayList<CarRental>());
		this.cars = cars;
	}

	/// Méthodes
	
	// Récupérer la liste des voitures dispo tel date et telle durée 
	public List<Car> getAvailableCars(LocalDate d, int duration) {
		ArrayList<Car> availableCars = new ArrayList<>();
		LocalDate[] dates = DateTools.getDays(d, duration);
		for (Car c : cars) {
			if (isAvailable(c, dates)) {
				availableCars.add(c);
			}
		}
		return availableCars;
	}
	
	// On voit si une voiture est dispo pendant ces dates 
	private boolean isAvailable(Car c, LocalDate[] dates) {
		for (CarRental carRental : payingItemList) {
			if (c.getNumberPlate().equals(carRental.getCarNumber()) &&
				(carRental.includeADate(dates)) ) {
				return false;	
			}	
		}
		return true;
	}
	
	// On réserve une voiture 
	public CarRental book(Car c, LocalDate d, int duration) throws NotPossibleCarRentalException  {
		CarRental carRental = null;
		if (cars == null || !(cars.contains(c)) )
			throw new NotPossibleCarRentalException("Not known car");
		LocalDate[] dates = DateTools.getDays(d, duration);
		if (isAvailable(c, dates)) {
			carRental = new CarRental(c, d, duration);
			payingItemList.add(carRental);
		}
		return carRental;
	}
	
	// Recherche d'une voiture correspondant à la description 
	public CarRental find(Description description) {
		List<Car> listeVoitures = this.getAvailableCars(description.getDateDepart(), description.getDuree());
		listeVoitures.sort(Comparator.comparing(Car::getDayPrice));
		CarRental cr = null; 
		try{
			if(listeVoitures.isEmpty()) {
				return null; 
			}
			cr = this.book(listeVoitures.get(0), description.getDateDepart(), description.getDuree()); 
		}catch(NotPossibleCarRentalException e) {
			e.getMessage(); 
		}
		return cr; 
	}
}
