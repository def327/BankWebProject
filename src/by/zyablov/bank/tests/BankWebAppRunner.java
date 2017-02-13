package by.zyablov.bank.tests;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.beans.BankAccount;
import by.zyablov.bank.beans.CreditCardType;
import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.beans.UserProfileAdmin;
import by.zyablov.bank.beans.UserProfileClient;
import by.zyablov.bank.dao.DaoAuthorityType;
import by.zyablov.bank.dao.DaoBankAccount;
import by.zyablov.bank.dao.DaoCreditCardType;
import by.zyablov.bank.dao.DaoUserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorAuthorityType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorBankAccount;
import by.zyablov.bank.dao.interfaces.DaoBehaviorCreditCardType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException, DaoException {

		DaoBehaviorBankAccount dao = new DaoBankAccount();
		
		dao.updateBankAccountCurrentBalance(3, 100);
				
		DataBaseManager.getInstance().closeDataBaseManager();
	}
}
