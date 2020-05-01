package forum;

public class Controleur {

	private GestionnaireForum registreF = new GestionnaireForum();
	private GestionnaireCanal registreC = new GestionnaireCanal();
	private UserConsole ui = new UserConsole();

	public void start() throws Exception {
		String commande = ui.lireCommande();
		switch (commande.charAt(0)) {
		case UserConsole.COM_CREER_FORUM:
			creerForum();
			start();
			break;
		case UserConsole.COM_CREER_CANAL:
			creerCanal();
			start();
			break;
		case UserConsole.COM_POSTER_MESSAGES:
//			posterMessage();
			start();
			break;
		case UserConsole.COM_LIRE_MESSAGES:
//			lireMessage();
			start();
			break;
		case UserConsole.COM_STOP:
			ui.afficher("Au revoir ");
			// Memoire.save(registre, "sauvegarde.txt");
			System.exit(0);
			break;
		default:
			ui.afficher("La commande spécifiée n'existe pas\n");
			Thread.sleep(1000);
			start();
		}
	}

	private void creerForum() {
		String nomForum = ui.getValeur("Nom du forum :");
		registreF.addForum(nomForum);

	}

	private void creerCanal() {
		String nomForum = ui.getValeur("Entrer le nom du forum dans lequel vous voulez créer un canal :");
		while (!GestionnaireForum.doesExist(nomForum)) {
			System.out.println("Erreur : Il n'y a aucun forum de ce nom.");
			nomForum = ui.getValeur("Entrer le nom du forum dans lequel vous voulez créer un canal :");
		}

		String typeCanal;
		System.out.println("Quel type de canal voulez-vous créer ?");
		typeCanal = ui.getValeur("Entrer \"c\" pour canal ou \"b\" pour canal de brèves");
		while (!(typeCanal.contentEquals("c") || typeCanal.contentEquals("b"))) {
			System.out.println("Erreur : donnée invalide.");
			typeCanal = ui.getValeur("Quel type de canal voulez-vous créer ?");
		}

		String nomCanal = ui.getValeur("Entrer le nom du canal");

		if (typeCanal.contentEquals("c")) {
			System.out.println("Voulez-vous changer le nombre de messages max possibles pour ce canal?");
			String nb = ui.getValeur("Répondre y pour oui, n pour non");
			try {
				int maxMessage = Integer.parseInt(nb);
				registreC.CreerCanal(nomCanal, maxMessage);
			} catch (NumberFormatException nfe) {
				System.out.println("Erreur, ce n'est pas un entier");
			}
		} else {
			String nb = ui.getValeur("Quelle taille max voulez-vous pour les brèves?");
			try {
				int tailleBreve = Integer.parseInt(nb);
				registreC.CreerCanalDeBreve(nomCanal, tailleBreve);
			} catch (NumberFormatException nfe) {
				System.out.println("Erreur, ce n'est pas un entier");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Controleur c = new Controleur();
		c.start();
	}
}