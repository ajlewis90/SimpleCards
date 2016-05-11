package org.joel.cards.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joel.cards.model.Card;
import org.joel.cards.model.CardStatusDescription;
import org.joel.cards.model.CardStatusHistory;


public class CardService {

	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JoinsTutorial";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "Cellfone01";
	Connection con = null;
	Statement stmt = null;

	/** Returns all card status description **/
	public List<CardStatusDescription> getCardStatusDescription(){
		List<CardStatusDescription> csdList = new ArrayList<>();


		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select * from card_status_description;";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				CardStatusDescription csd = new CardStatusDescription();
				csd.setCard_status_description_oid(rs.getInt(1));
				csd.setCard_status_description(rs.getString(2));
				csd.setCard_status_oid(rs.getInt(3));
				csdList.add(csd);
			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {

			closeConnection(stmt, con);

		}
		return csdList;
	}

	private void closeConnection(Statement stmt, Connection con) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {

		}
	}

	/** Retrieves Card object based on card number information **/
	public Card getCardNumber(int cardNumber){
		Card card = null;


		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select * from card "
					+ "where card_number = " + cardNumber;

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				card = new Card();
				card.setCard_oid(rs.getInt(1));
				card.setCard_number(rs.getInt(2));
				card.setCard_owner_name(rs.getString(3));
				card.setCard_status_oid(rs.getInt(4));


			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return card;
	}

	/** Maps card status oid to corresponding description **/
	public String mapCardStatusOIDToDescription(int cardStatusOID){
		String cardStatusDescription = null;


		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select card_Status_Description from card_status_description "
					+ "where card_status_oid = " + cardStatusOID;

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				CardStatusDescription csd = new CardStatusDescription();

				csd.setCard_status_description(rs.getString(1));
				cardStatusDescription = csd.getCard_status_description();

			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardStatusDescription;
	}

	/**Maps card status description to the corresponding oid **/
	public int mapCardStatusDescriptionToOID(String cardStatusDescription){
		int cardStatusOID = 0;

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select card_status_oid from card_status_description "
					+ "where card_status_description = " + "'" + cardStatusDescription + "'";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				CardStatusDescription csd = new CardStatusDescription();

				csd.setCard_status_oid(rs.getInt(1));
				cardStatusOID = csd.getCard_status_oid();

			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardStatusOID;
	}

	/** Returns card owner's name based on card's oid **/
	public String mapCardOIDToOwner(int cardOID){
		String cardOwnerName = null;

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select card_owner_name from card "
					+ "where card_oid = " + cardOID;

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Card card = new Card();

				card.setCard_owner_name(rs.getString(1));
				cardOwnerName = card.getCard_owner_name();

			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardOwnerName;
	}

	/** Returns card number based on card oid **/
	public int mapCardOIDToNumber(int cardOID){
		int cardNumber = 0;

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select card_number from card "
					+ "where card_oid = " + cardOID;

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Card card = new Card();

				card.setCard_number(rs.getInt(1));
				cardNumber = card.getCard_number();

			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardNumber;
	}

	/** Returns card oid based on card number **/
	public int mapCardNumberToOID(int cardNumber){
		int cardOID = 0;

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "select card_oid from card "
					+ "where card_number = " + cardNumber;

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Card card = new Card();

				card.setCard_oid(rs.getInt(1));
				cardOID = card.getCard_oid();

			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardOID;
	}


	/**Returns all Card information **/
	public List<Card> getAllCards(){
		List<Card> cardList = new ArrayList<>();

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "SELECT card_oid, card_number, card_owner_name, "
					+ "card_status_oid FROM"
					+ " Card c";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Card card = new Card();
				card.setCard_oid(rs.getInt(1));
				card.setCard_number(rs.getInt(2));
				card.setCard_owner_name(rs.getString(3));
				card.setCard_status_oid(rs.getInt(4));
				cardList.add(card);
			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cardList;
	}

	/** Returns all Card Staus History information **/
	public List<CardStatusHistory> getAllCardStatusHistory(){
		List<CardStatusHistory> cshList = new ArrayList<>();

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "SELECT csh_oid, card_oid, old_card_status_oid, "
					+ "new_card_status_oid, date_changed FROM"
					+ " Card_Status_History";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				CardStatusHistory csh = new CardStatusHistory();
				csh.setCsh_oid(rs.getInt(1));
				csh.setCard_oid(rs.getInt(2));
				csh.setOld_card_status_oid(rs.getInt(3));
				csh.setNew_card_status_oid(rs.getInt(4));
				csh.setDate_changed(rs.getDate(5));
				cshList.add(csh);
			}
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}
		return cshList;
	}

	public boolean ifCardExists(int cardNumber){

		Boolean result = true;

		try{

			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "SELECT card_number FROM Card"
					+ " where card_number = " + cardNumber;

			ResultSet rs = stmt.executeQuery(query);
			
			if(!rs.next()){
				System.out.println("This is a valid card");
				result = false;
			}

			else{

				System.out.println("A card with this number already exists");

			}

			
		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}



		return result;
	}


	public void addNewCard(int cardNumber, String cardOwnerName, int cardStatusOID) {

		try{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "Insert into Card (card_number, card_owner_name, card_status_oid) "
					+ "Values(" + cardNumber + ", "+ "'" + cardOwnerName + "'" + ", " + cardStatusOID + ")"; 

			ResultSet rs = stmt.executeQuery(query);

		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}

	}

	public void addNewCardStatusHistory(int cardNumber, int oldCardStatusOID, int newCardStatusOID) {

		int cardOID = 0;
		cardOID = mapCardNumberToOID(cardNumber);
		java.util.Date today=new Date();
		java.sql.Date date=new java.sql.Date(today.getTime()); //your SQL date object
		SimpleDateFormat simpDate = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpDate.format(date)); //output String in MM-dd-yyyy

		try{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "Insert into Card_Status_History (card_oid, old_card_status_oid, new_card_status_oid, date_changed) "
					+ "Values(" + cardOID + ", " + oldCardStatusOID + ", " + newCardStatusOID + ", " + "'" + simpDate.format(date) + "'" +")";;

					ResultSet rs = stmt.executeQuery(query);

		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}

	}
	
	public void updateCard(int cardNumber, String cardOwnerName, int cardStatusOID) {

		try{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			String query = "Update Card Set card_status_oid = " + cardStatusOID 
					+  " where card_number= " + cardNumber; 

			ResultSet rs = stmt.executeQuery(query);

		}catch (SQLException | ClassNotFoundException ex) {

		} finally {
			closeConnection(stmt, con);
		}

	}

}
