package openClosedPrinciples.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Service<T extends PayingItem>{
	protected List<T> payingItemList = new ArrayList<>();

	/// Constructeurs 
	
	public Service(List<T> payingItemList) {
		this.payingItemList = payingItemList;
	}
	
	
	/// Accesseur 
	
	protected  List<T> getpayingItemList(){
		return payingItemList;
	}
	
	
	/// Méthodes 
	
	// Trier la liste d'item par prix 
	public List<T> sortedByPrice() {
		payingItemList.sort(Comparator.comparing(PayingItem::getPrice));
		return payingItemList;
	}
	
	// Récupérer l'item le moins cher 
	public T lessExpensiveItem(){
			sortedByPrice();
			return payingItemList.get(0);
	}
	
	// Ajouter un item à la liste 
	public void add(T payingItem) {
		payingItemList.add(payingItem);
	}

	// Trouver 
	public abstract T find(Description description) throws AucunItemCorrespondant; 
	
}
