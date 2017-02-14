package by.zyablov.bank.tests;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.beans.BankAccountState;
import by.zyablov.bank.beans.CreditCard;
import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.beans.UserProfileAdmin;
import by.zyablov.bank.beans.UserProfileClient;
import by.zyablov.bank.dao.DaoAuthorityType;
import by.zyablov.bank.dao.DaoBankAccount;
import by.zyablov.bank.dao.DaoBankAccountState;
import by.zyablov.bank.dao.DaoCreditCard;
import by.zyablov.bank.dao.DaoCreditCardType;
import by.zyablov.bank.dao.DaoUser;
import by.zyablov.bank.dao.DaoUserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorAuthorityType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccount;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccountState;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCard;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUser;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException, DaoException {

		try{
		
		DaoBehaviorUser dao = new DaoUser();
		
		
	
		
		
		}catch(StackOverflowError e){
			
			System.out.println("I in the catch block!");
			e.printStackTrace();
			
		}finally{
			System.out.println("I in the finally block !");
		}

//		User user = new User();
//		
//		user.setLogin("def45");
//		user.setPassword("1234564");
//		user.setAuthorityType(new AuthorityType());
//		user.getAuthorityType().setId(2);
//		
//		dao.addNewUserClient(user);

//		if (user == null) {
//			System.out.println("Empty!");
//		} else {
//
//			System.out.println(user.getId());
//			System.out.println(user.getLogin());
//			System.out.println(user.getPassword());
//			System.out.println(user.getAuthorityType().getId());
//			
//
//		}

		DataBaseManager.getInstance().closeDataBaseManager();
	}
}
