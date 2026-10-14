package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.afficherJeuDeCarte());
		
		System.out.println("nombre de cartes conforme ? " + jeu.checkCount());

	}
}