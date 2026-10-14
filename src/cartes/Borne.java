package cartes;

public class Borne extends Carte {
	private int km;
	
	@Override
	public String toString() {
		return km + "KM";
	}
	
	public Borne(int km) {
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && km == ((Borne) obj).km;
	}

	@Override
	public int hashCode() {
	    return 31 * super.hashCode() + km;
	}

}
