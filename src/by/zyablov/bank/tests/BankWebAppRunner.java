package by.zyablov.bank.tests;

import java.sql.SQLException;

import by.zyablov.bank.beans.AuthorityType;
import by.zyablov.bank.dao.DaoAuthorityType;
import by.zyablov.bank.dao.interfaces.DaoBehaviorAuthorityType;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException {


		AuthorityType bean = new AuthorityType();
		bean.setId(1);
		
		DaoBehaviorAuthorityType dao = new DaoAuthorityType();
		
		try {
			
			bean.setAuthorityTypeTitle(dao.getAuthorityType(bean).getAuthorityTypeTitle());
			System.out.println(bean.getId() + " " + bean.getAuthorityTypeTitle());
			
		} catch (DaoException e) {
			
			System.out.println("Get problem with dao!!!");
			e.printStackTrace();
		}

	

	}

}
