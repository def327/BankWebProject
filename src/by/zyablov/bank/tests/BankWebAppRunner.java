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
		
		DaoBehaviorUserProfile dao = new DaoUserProfile();
		
		UserProfile profile = dao.getUserProfile(6);
		
		if(profile == null){
			System.out.println("Empty!");
		}else{
			
			System.out.println(profile.getId());
			System.out.println(profile.getFirstName());
			System.out.println(profile.getLastName());
			System.out.println(profile.getPassportSeria());
			System.out.println(profile.getEmail());
			
			if(profile instanceof UserProfileClient){
				
				UserProfileClient clientProfile = (UserProfileClient)profile;
				
				System.out.println(clientProfile.getBankAccount().getId() + " - bank account");
				
			}
			
		}

		DataBaseManager.getInstance().closeDataBaseManager();
	}
}
