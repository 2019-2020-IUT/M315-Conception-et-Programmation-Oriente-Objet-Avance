package openClosedPrinciples.core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireVoyages {
	private static TravelOrganizer to = new TravelOrganizer(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//// GESTION DU VOYAGE CHOISI PAR L'UTILISATEUR 

		/// On récupère le départ
		System.out.println("De où partez-vous ?");
		String depart = sc.nextLine();

		/// On récupère la destination
		System.out.println("Où voulez-vous aller ?");
		String destination = sc.nextLine();

		/// On récupère la durée du voyage
		System.out.println("Combien de temps voulez-vous partir?");
		int duree = Integer.parseInt(sc.nextLine());
		 
		//Date (non demandée par l'utilisateur) 
		LocalDate ld = LocalDate.of(2019, Month.OCTOBER, 18); 
		
		//Date pour tester  
		LocalDate ldr = LocalDate.of(2019, Month.JUNE, 18);
		LocalTime lt = LocalTime.now();

		//Description du voyage de l'utilisateur 
		Description d = new Description(depart, destination, ld, duree);
		
		/// GESTION DES VOLS

		// Première compagnie de vols  
		Flight f1 = new Flight(350, ld, lt, depart, destination);
		Flight f2 = new Flight(100, ld, lt, depart, destination); // moins cher
		Flight f3 = new Flight(56, ld, lt, "Cannes", destination); // n'a pas le bon départ
		ArrayList<Flight> flights1 = new ArrayList<>();
		flights1.add(f1);
		flights1.add(f2);
		flights1.add(f3);
		FlightService fs1 = new FlightService(flights1);
		to.addAirlineCompany(fs1);
		
		// Deuxième compagnie de vols 
		Flight f4 = new Flight(20, ld, lt, depart, "Tokyo"); // n'a pas la bonne destination
		Flight f5 = new Flight(22, ldr, lt, depart, destination); // n'a pas la bonne date
		ArrayList<Flight> flights2 = new ArrayList<>();
		flights2.add(f4);
		flights2.add(f5);
		FlightService fs2 = new FlightService(flights2);
		to.addAirlineCompany(fs2);
		
				
		
		/// GESTION DES LOCATIONS DE VOITURES

		// Première compagnie qui contiendra 3 voitures 
		Car c1 = new Car("111", 10); //sera réservée plus tard 
		Car c2 = new Car("222", 15); 
		Car c3 = new Car("333", 30); //sera réservée plus tard 
		ArrayList<Car> cs1 = new ArrayList<>();
		cs1.add(c1);
		cs1.add(c2);
		cs1.add(c3);
		CarRentalService crs1 = new CarRentalService(cs1);
		to.addCarRentCompany(crs1);
		
		// Deuxième compagnie qui contiendra 2 voitures S
		Car c4 = new Car("444", 4); //voiture la moins chère, mais sera réservée plus tard 
		Car c5 = new Car("555", 50); 
		ArrayList<Car> cs2 = new ArrayList<>();
		cs2.add(c4);
		cs2.add(c5);
		CarRentalService crs2 = new CarRentalService(cs2);
		to.addCarRentCompany(crs2);
		
		
		try {
			// On réserve 3 voitures 
			crs1.book(c1, ld, duree);
			crs1.book(c3, ld, duree);
			crs2.book(c4, ld, duree);
		} catch (NotPossibleCarRentalException e) {
			System.out.println(e.getMessage());
		}	
		
		
		try {
			Trip voyageChoisi = to.createATrip(d); 
			
			//Affichage du meilleur vol 
			System.out.println("Le meilleur vol pour partir de "+ depart +" et arriver à " + destination + 
					" le 18/10/2019 est : \n\t" + voyageChoisi.getItems().get(0));

			//Affichage de la meilleure location de voiture 
			System.out.println("La meilleure voiture à louer pour une durée de " + duree + 
					" jours à partir du " + ld +" est : \n\t" + voyageChoisi.getItems().get(1));
		} catch(AucunItemCorrespondant e) {
			System.out.println(e.getMessage()); 
		}
		
		
	}
}
