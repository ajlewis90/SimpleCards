package org.joel.cards.model;

public class Card {
	
	private int card_oid;
	private int card_number;
	private String card_owner_name;
	private int card_status_oid;
	
	public int getCard_oid() {
		return card_oid;
	}
	
	public void setCard_oid(int card_oid) {
		this.card_oid = card_oid;
	}
	
	public int getCard_number() {
		return card_number;
	}
	
	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	
	public String getCard_owner_name() {
		return card_owner_name;
	}
	
	public void setCard_owner_name(String card_owner_name) {
		this.card_owner_name = card_owner_name;
	}
	
	public int getCard_status_oid() {
		return card_status_oid;
	}
	
	public void setCard_status_oid(int card_status_oid) {
		this.card_status_oid = card_status_oid;
	}
	
	

}
