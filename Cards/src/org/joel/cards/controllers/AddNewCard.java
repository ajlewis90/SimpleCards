package org.joel.cards.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joel.cards.services.CardService;

/**
 * Servlet implementation class AddNewCard
 */
@WebServlet("/AddNewCard")
public class AddNewCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//5 things - a.get all form values as request parameters
		//	  		b. map cardstatus to cardstatusoid
		//			c. fire query to check if card number exists already - if so msg else do d.
		//			d. fire query to insert new card into database
		//          e. fire another query to add a new record into card status history
		
		// also construct jsp pages to view cards with different statuses - view expired, active etc (use ajax??)
		
		
		String cardOwnerName, cardStatus;
		int cardStatusOID = 0;
		int cardNumber;
		response.setContentType("text/html");
		
		
		String cardNumberVal = request.getParameter("cardNumber");
    	
		
		cardNumber = Integer.parseInt(cardNumberVal);
	
		
		cardOwnerName = request.getParameter("cardOwnerName");
		cardStatus = request.getParameter("cardStatus");
		
		CardService cs = new CardService();
		cardStatusOID = cs.mapCardStatusDescriptionToOID(cardStatus);
		
		
		//call method to fire insert query into database
		cs.addNewCard(cardNumber, cardOwnerName, cardStatusOID);
		//cs.addNewCardStatusHistory(cardNumber, cardStatusOID);
		//System.out.println("New card has been added");
		response.sendRedirect("viewAllCards.jsp");
		
		
		
		
	}

}
