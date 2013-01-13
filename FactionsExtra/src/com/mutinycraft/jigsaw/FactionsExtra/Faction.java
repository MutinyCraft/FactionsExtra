package com.mutinycraft.jigsaw.FactionsExtra;

public class Faction implements Comparable<Faction> {

	private String factionName;
	private int score;
	private int tier;

	public Faction(String fName, int s, int t) {
		this.factionName = fName;
		this.score = s;
		this.tier = t;
	}

	public String getFactionName() {
		return this.factionName;
	}

	public int getScore() {
		return this.score;
	}

	public int getTier() {
		return this.tier;
	}

	public int compareTo(Faction f) {
		return f.getScore() - getScore();
	}
}
