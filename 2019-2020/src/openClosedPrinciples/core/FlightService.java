package openClosedPrinciples.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mireille Blay-Fornarino
 *
 * 6 oct. 2018
 */
public class FlightService extends Service<Flight> {

	/// Constructeurs 
	
	public FlightService(ArrayList<Flight> flights) {
		super(flights);
	}
	
	
	/// Méthodes
	
	// Récupérer les vols de cette date 
	public List<Flight> getFlights(LocalDate d) {
		Stream<Flight> parallelStream = super.getpayingItemList().parallelStream(); 
		Stream<Flight> results = parallelStream.filter(f -> (f.getDepartDate().equals(d)) ) ;
		return results.collect(Collectors.toCollection(ArrayList::new));
	}

	// Récupérer les vols de cette date + lieux départ et destination 
	public ArrayList<Flight> getFlights(LocalDate d, String from, String to) {
		Stream<Flight> parallelStream = super.getpayingItemList().parallelStream(); 
		Stream<Flight> results = parallelStream.filter(f -> 
		             f.match(d, from, to))  ;
		return results.collect(Collectors.toCollection(ArrayList::new));
	}
	
	// Recherche d'un vol correspondant à la description 
		public Flight find(Description description) {
			ArrayList<Flight> listeVols = this.getFlights(description.getDateDepart(), description.getDepart(), description.getDestination());
			listeVols.sort(Comparator.comparing(Flight::getPrice));
			if(listeVols.isEmpty()) {
				return null; 
			}
			return listeVols.get(0); 
		}
}
