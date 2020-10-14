package TD4.travel;

import java.time.LocalDate;

public class Description {

	private LocalDate departDate;
	private String departPlace;
	private String arrivalPlace;
	private int duration;
	
	public Description( ) {
		
	}
	
	/**
	 * @return the departDate
	 */
	public LocalDate getDepartDate() {
		return departDate;
	}
	/**
	 * @param departDate the departDate to set
	 */
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	/**
	 * @return the departPlace
	 */
	public String getDepartPlace() {
		return departPlace;
	}
	/**
	 * @param departPlace the departPlace to set
	 */
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	/**
	 * @return the arrivalPlace
	 */
	public String getArrivalPlace() {
		return arrivalPlace;
	}
	/**
	 * @param arrivalPlace the arrivalPlace to set
	 */
	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
