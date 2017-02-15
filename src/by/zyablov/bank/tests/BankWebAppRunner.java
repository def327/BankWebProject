package by.zyablov.bank.tests;

import java.sql.SQLException;
import by.zyablov.bank.beans.UserProfile;
import by.zyablov.bank.dao.DaoUserProfile;
import by.zyablov.bank.dao.interfaces.DaoBehaviorUserProfile;
import by.zyablov.bank.datasource.DataBaseManager;
import by.zyablov.bank.exceptions.DaoException;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException, DaoException {

		try {

			DaoBehaviorUserProfile dao = new DaoUserProfile();

			int userId = 3;
			int authorityTypeId = 2;

			UserProfile profile = dao.getUserProfile(userId, authorityTypeId);

			if (profile != null) {

				System.out.println(profile.getId());
				System.out.println(profile.getFirstName());
				System.out.println(profile.getLastName());
				System.out.println(profile.getEmail());
				System.out.println(profile.getPassportSeria());
				System.out.println(profile.getClass());

			} else {
				System.out.println("Empty!");
			}

		} catch (DaoException e) {

			e.printStackTrace();

		} finally {
			DataBaseManager.getInstance().closeDataBaseManager();
		}
	}
}
