package cartes;

public class JeuDeCartes {
	private static final int NB_MAX_CARTES = 110;
	
	private static class Configuration{
		private int nbExemplaire;
		private Carte carte;

		
		private Configuration(int nbExemplaire, Carte carte) {
			this.nbExemplaire = nbExemplaire;
			this.carte = carte;
		}

		public int getNbExemplaire() {
			return nbExemplaire;
		}

		public Carte getCarte() {
			return carte;
		}
	}
	
	public String afficherJeuDeCarte() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			chaine.append(typesDeCartes[i].getNbExemplaire() + " " + typesDeCartes[i].carte + "\n");
		};
		return chaine.toString();
	}
	
	private Configuration[] typesDeCartes = {
		new Configuration(10, new Borne(25)),
		new Configuration(10, new Borne(50)),
		new Configuration(10, new Borne(75)),
		new Configuration(12, new Borne(100)),
		new Configuration(4, new Borne(200)),
		new Configuration(14, new Parade(Type.FEU)),
		new Configuration(6, new FinLimite()),
		new Configuration(6, new Parade(Type.ESSENCE)),
		new Configuration(6, new Parade(Type.CREVAISON)),
		new Configuration(6, new Parade(Type.ACCIDENT)),
		new Configuration(5, new Attaque(Type.FEU)),
		new Configuration(4, new DebutLimite()),
		new Configuration(3, new Attaque(Type.ESSENCE)),
		new Configuration(3, new Attaque(Type.CREVAISON)),
		new Configuration(3, new Attaque(Type.ACCIDENT)),
		new Configuration(1, new Botte(Type.FEU)),
		new Configuration(1, new Botte(Type.ESSENCE)),
		new Configuration(1, new Botte(Type.CREVAISON)),
		new Configuration(1, new Botte(Type.ACCIDENT))
	};
	
	public Carte[] donnerCartes() {
		Carte[] tabCartes = new Carte[NB_MAX_CARTES];
		for (Configuration configuration : typesDeCartes) {
			for (int i = 0; i < configuration.getNbExemplaire(); i++) {
				tabCartes[i] = configuration.carte;
			}
		}
		return tabCartes;
	}
}
