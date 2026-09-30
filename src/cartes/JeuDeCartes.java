package cartes;

public class JeuDeCartes {
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
			chaine.append(typesDeCartes[i].getNbExemplaire());
			chaine.append(" ");
			chaine.append(typesDeCartes[i].carte);
			chaine.append("\n");
			
		};
		return chaine.toString();
	}
	
	
	public Carte[] donnerCartes() {
		int nbMax = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			nbMax += typesDeCartes[i].nbExemplaire;
		}
		Carte[] tabCartes = new Carte[nbMax];
		int index = 0;
		for (Configuration configuration : typesDeCartes) {
			for (int i = 0; i < configuration.getNbExemplaire(); i++) {
				tabCartes[index] = configuration.carte;
				index++;
			}
		}
		return tabCartes;
	}
	
	public boolean checkCount() {
		Carte[] tabCartes = donnerCartes();
		int nbMax = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			nbMax += typesDeCartes[i].nbExemplaire;
		}
		return nbMax == tabCartes.length;
	}
}
