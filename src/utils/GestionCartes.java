package utils;

import java.util.*;

public class GestionCartes {
	private static final Random RANDOM = new Random();

    public static <T> T extraire(List<T> liste) {
        return liste.remove(RANDOM.nextInt(liste.size()));
    }

    public static <T> T extraireIterator(List<T> liste) {
        int index = RANDOM.nextInt(liste.size());
        ListIterator<T> it = liste.listIterator();
        T element = null;
        for (int i = 0; i <= index; i++) {
            element = it.next();
        }
        it.remove();
        return element;
    }

    public static <T> List<T> melanger(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        while (!liste.isEmpty()) {
            resultat.add(extraire(liste));
        }
        return resultat;
    }

    public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
        if (l1.size() != l2.size()) return false;
        for (T element : l1) {
            if (Collections.frequency(l1, element) != Collections.frequency(l2, element)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        List<T> dejaTraites = new ArrayList<>();
        for (T element : liste) {
            if (!dejaTraites.contains(element)) {
                dejaTraites.add(element);
                resultat.addAll(Collections.nCopies(Collections.frequency(liste, element), element));
            }
        }
        return resultat;
    }

    public static <T> List<T> rassemberV2(List<T> liste) {
        List<T> restants = new ArrayList<>(liste);
        List<T> resultat = new ArrayList<>();
        while (!restants.isEmpty()) {
            T reference = restants.get(0);
            for (ListIterator<T> it = restants.listIterator(); it.hasNext();) {
                T element = it.next();
                if (Objects.equals(element, reference)) {
                    resultat.add(element);
                    it.remove();
                }
            }
        }
        return resultat;
    }

    public static <T> boolean verifierRassemblement(List<T> liste) {
        ListIterator<T> it = liste.listIterator();
        if (!it.hasNext()) return true;
        T courant = it.next();
        while (it.hasNext()) {
            T suivant = it.next();
            if (!Objects.equals(suivant, courant)) {
                ListIterator<T> reste = liste.listIterator(it.nextIndex());
                while (reste.hasNext()) {
                    if (Objects.equals(reste.next(), courant)) return false;
                }
                courant = suivant;
            }
        }
        return true;
    }
}
