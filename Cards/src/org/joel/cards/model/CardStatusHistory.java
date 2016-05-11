package org.joel.cards.model;

import java.sql.Date;

public class CardStatusHistory {

	private int csh_oid;
	private int card_oid;
	private int old_card_status_oid;
	private int new_card_status_oid;
	private Date date_changed;
	
	public int getCsh_oid() {
		return csh_oid;
	}
	
	public void setCsh_oid(int csh_oid) {
		this.csh_oid = csh_oid;
	}
	
	public int getCard_oid() {
		return card_oid;
	}
	
	public void setCard_oid(int card_oid) {
		this.card_oid = card_oid;
	}
	
	public int getOld_card_status_oid() {
		return old_card_status_oid;
	}
	
	public void setOld_card_status_oid(int old_card_status_oid) {
		this.old_card_status_oid = old_card_status_oid;
	}
	public int getNew_card_status_oid() {
		return new_card_status_oid;
	}
	
	public void setNew_card_status_oid(int new_card_status_oid) {
		this.new_card_status_oid = new_card_status_oid;
	}
	
	public Date getDate_changed() {
		return date_changed;
	}
	
	public void setDate_changed(Date date_changed) {
		this.date_changed = date_changed;
	}	
	
}
