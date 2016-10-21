package mg.rova.gamestore.shared;

public enum Category {

	ACTION("Action"), ADVENTURE("Aventure"), ACTION_ADVENTURE("Action-Aventure"), JEU_DE_ROLE("Jeu de rôle"), REFLEXION("Reflexion"), SIMULATION("Simulation"), STRATEGY("Strategie"), OTHERS("Autres genres");

	private String category;

	private Category(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return category;
	}

}
