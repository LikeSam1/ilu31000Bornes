package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

    private Carte[] cartes;
    private int nbCartes;
    private int modCount = 0;

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) {
        if (nbCartes >= cartes.length) {
            throw new IllegalStateException("Le sabot est plein");
        }
        cartes[nbCartes] = carte;
        nbCartes++;
        modCount++;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new Iterator<Carte>() {
            private int curseur = 0;
            private int expectedModCount = modCount;
            private boolean canRemove = false;

            @Override
            public boolean hasNext() {
                return curseur < nbCartes;
            }

            @Override
            public Carte next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Carte c = cartes[curseur];
                curseur++;
                canRemove = true;
                return c;
            }

            @Override
            public void remove() {
                if (!canRemove) {
                    throw new IllegalStateException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = curseur - 1; i < nbCartes - 1; i++) {
                    cartes[i] = cartes[i + 1];
                }
                cartes[nbCartes - 1] = null;
                nbCartes--;
                curseur--;
                modCount++;
                expectedModCount = modCount;
                canRemove = false;
            }
        };
    }

    public Carte piocher() {
        if (estVide()) {
            throw new IllegalStateException("Le sabot est vide");
        }
        Iterator<Carte> it = iterator();
        Carte c = it.next();
        it.remove();
        return c;
    }
}