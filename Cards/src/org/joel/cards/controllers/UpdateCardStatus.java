package org.joel.cards.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joel.cards.services.CardService;

/**
 * Servlet implementation class UpdateCardStatus
 */
@WebServlet("/UpdateCardStatus")
public class UpdateCardStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCardStatus() {
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
		
		// a. In jsp check if old and new card statuses are equal if so javascript to diplay messagebox, else b
		// b. get all request parameters after clicking submit (this includes both old and new card status)
		// c. map new and old cardstatuses to their respective card status oids
		// d. fire query to update the card
		// e. fire query to add new card_status_history record
		
		String cardOwnerName, oldCardStatus, newCardStatus;
		int oldCardStatusOID, newCardStatusOID = 0;
		int cardNumber;
		
		cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
		cardOwnerName = request.getParameter("cardOwnerName");
		oldCardStatus = request.getParameter("oldCardStatus");
		newCardStatus = request.getParameter("newCardStatus");
		
		CardService cs = new CardService();
		oldCardStatusOID = cs.mapCardStatusDescriptionToOID(oldCardStatus);
		newCardStatusOID = cs.mapCardStatusDescriptionToOID(newCardStatus);
		
		cs.updateCard(cardNumber, cardOwnerName, newCardStatusOID);
		cs.addNewCardStatusHistory(cardNumber, oldCardStatusOID, newCardStatusOID);
		System.out.println("Card has been updated");
		
		response.sendRedirect("viewCardStatusHistory.jsp");
	}

}
