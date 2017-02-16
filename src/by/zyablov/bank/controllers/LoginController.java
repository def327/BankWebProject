package by.zyablov.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.zyablov.bank.commands.CommandBehavior;
import by.zyablov.bank.commands.factory.CommandEnum;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		loginProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginProcess(request, response);
	}

	private void loginProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommandBehavior command = CommandEnum.USER_LOGIN.getCommand();
		String nextPage = command.execute(request);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

}
