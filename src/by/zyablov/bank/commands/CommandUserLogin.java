package by.zyablov.bank.commands;

import javax.servlet.http.HttpServletRequest;

public class CommandUserLogin implements CommandBehavior {

	@Override
	public String execute(HttpServletRequest request) {
		
		System.out.println("LOGIN");
		
		return null;
	}

}
