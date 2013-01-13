package com.mutinycraft.jigsaw.FactionsExtra;

public class Faction implements Comparable<Faction> {

	private String factionName;
	private int score;

	public Faction(String fName, int s) {
		this.factionName = fName;
		this.score = s;
	}

	public String getFactionName() {
		return this.factionName;
	}

	public int getScore() {
		return this.score;
	}

	public int compareTo(Faction f) {
		return f.getScore() - getScore();
	}
}
