package openClosedPrinciples.core;

import java.time.LocalDate;
import java.util.Date;

public class Description {
	private String depart; 
	private String destination; 
	private LocalDate dateDepart; 
	private int duree; 
	
	
	/// Constructeurs 
	
	// Vide 
	public Description() {
		depart = null;
		destination = null;
		dateDepart = null;
		duree = 0;
	}
	
	// Avec tout rempli 
	public Description(String depart, String destination, LocalDate dateDepart, int duree) {
		this.depart = depart;
		this.destination = destination;
		this.dateDepart = dateDepart;
		this.duree = duree;
	}
	
	
	/// Accesseurs et mutateurs 

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	
	
}
