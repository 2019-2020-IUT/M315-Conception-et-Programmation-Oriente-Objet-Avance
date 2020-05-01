package openClosedPrinciples.core;

import java.time.LocalDate;

/**
 * Classe Utilitaire
 * 
 * 
 * @author Mireille Blay-Fornarino
 *
 *
 * 6 oct. 2018
 */
public final class DateTools {

	
	private DateTools() {
	    throw new IllegalStateException("Utility class");
	}

	public static LocalDate addDays(LocalDate date, int nbJour) {
		return date.plusDays(nbJour);
		}
	
	public static LocalDate[] getDays(LocalDate date, int nbJour) {
		int i = 0;
		LocalDate[] dates = new LocalDate[nbJour];
		dates[i] = date;
		i+=1;
		while (i < nbJour) {
			dates[i] = addDays(date,i);
			i++;
		}
		return dates;
	}
	
}
