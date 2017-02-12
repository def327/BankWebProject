package by.zyablov.bank.tests;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.beans.UserProfileAdmin;
import by.zyablov.bank.beans.UserProfileClient;
import by.zyablov.bank.dao.DaoCreditCardType;
import by.zyablov.bank.dao.DaoUserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException, DaoException {



		try {

			
			List<CreditCardType> list;
			
			DaoBehaviorCreditCardType dao1 = new DaoCreditCardType();
			
			list = dao1.getListOfCreditCardTypes();
			
			if(list== null){
				System.out.println("empty!");
				DataBaseManager.getInstance().closeDataBaseManager();
				return;
			}
			
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				CreditCardType creditCardType = (CreditCardType) iterator.next();
				
				System.out.println(creditCardType.getId() + " " + creditCardType.getCardTypeTitle());
			
				
			}

		} catch (DaoException e) {

			System.out.println("Get problem with dao!!!");
			e.printStackTrace();
		}

		DataBaseManager.getInstance().closeDataBaseManager();

	}

	// DaoBehaviorAuthorityType dao = new DaoAuthorityType();
	//
	// AuthorityType a = new AuthorityType();
	//
	// a.setId(1);
	//
	// AuthorityType b = dao.getAuthorityTypeById(a);
	//
	// System.out.println(b.getAuthorityTypeTitle());

}
