package cartes;

public class JeuDeCartes {
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
		return "";
	}
	
	private Configuration[] typesDeCartes = {
		new Configuration(10, new Borne(25)),
		new Configuration(10, new Borne(50)),
		new Configuration(10, new Borne(75)),
		new Configuration(12, new Borne(100)),
		new Configuration(4, new Borne(200)),
		new Configuration(14, new Parade(Type.FEU)),
//		new Configuration(6, new Borne(50)),
//		new Configuration(6, new Borne(25)),
//		new Configuration(6, new Borne(50)),
//		new Configuration(6, new Borne(25)),
//		new Configuration(5, new Borne(50)),
//		new Configuration(4, new Borne(25)),
//		new Configuration(3, new Borne(50)),
//		new Configuration(3, new Borne(25)),
//		new Configuration(3, new Borne(50)),
//		new Configuration(1, new Borne(25)),
//		new Configuration(1, new Borne(50)),
//		new Configuration(1, new Borne(25)),
//		new Configuration(1, new Borne(50))
	};
}
