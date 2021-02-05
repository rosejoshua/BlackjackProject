package com.skilldistillery.cards;

public enum Suit {
	
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	private Suit(String name) {
		this.name = name;
	}	
	
}
