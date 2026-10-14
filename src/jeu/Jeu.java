package jeu;

import java.util.*;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
        listeCartes = GestionCartes.melanger(listeCartes);
        sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }
}
