package by.zyablov.bank.tests;

import java.sql.SQLException;

import by.zyablov.bank.beans.User;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.beans.UserProfileAdmin;
import by.zyablov.bank.beans.UserProfileClient;
import by.zyablov.bank.dao.DaoUserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException, DaoException {

		User bean = new User();
		bean.setLogin("stans96");

		DaoBehaviorUserProfile dao = new DaoUserProfile();

		try {

			User user = new User();

			user.setId(2);

			UserProfile profile = dao.getUserProfile(user);

			if (profile == null) {
				System.out.println("empty profile!");
				DataBaseManager.getInstance().closeDataBaseManager();
				return;
			}

			if (profile instanceof UserProfileClient) {

				System.out.println(profile.getFirstName());
				System.out.println(profile.getLastName());
				System.out.println(profile.getEmail());
				System.out.println(profile.getPassportSeria());
				System.out.println(((UserProfileClient) profile).getBankAccount().getId());

			} else if (profile instanceof UserProfileAdmin) {

				System.out.println(profile.getFirstName());
				System.out.println(profile.getLastName());
				System.out.println(profile.getLastName());
				System.out.println(profile.getPassportSeria());
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
