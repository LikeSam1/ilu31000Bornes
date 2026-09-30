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
		if(obj instanceof Borne borne) {
			Integer kmP = new Integer(this.km);
			return kmP == borne.getKm();
			}
			return false;
	}


}
