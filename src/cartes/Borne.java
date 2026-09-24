package cartes;

public class Borne extends Carte {
	@Override
	public String toString() {
		return km + "KM";
	}

	private int km;
	
	public Borne(int km) {
		this.km = km;
	}

}
