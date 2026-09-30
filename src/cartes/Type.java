package cartes;


public enum Type {
	FEU("Feu vert", "Feu rouge", "Prioritaire"), 
	ESSENCE("Essence", "Panne d'essence", "Citerne"), 
	CREVAISON("Roue de secours", "Crevaison", "Increvable"), 
	ACCIDENT("Reparation", "Accident", "As du Volant");
	
	private final String attaque;
	private final String parade;
	private final String botte;
	
	private Type(String parade, String attaque, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
}
