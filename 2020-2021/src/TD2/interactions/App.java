package TD2.interactions;

/**
 * Main Application
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	@SuppressWarnings("unused")
		Controleur controleur;
		try {
			controleur = new Controleur();
	    	//controleur.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}