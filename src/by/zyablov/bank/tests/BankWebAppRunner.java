package by.zyablov.bank.tests;

import java.sql.SQLException;
import by.zyablov.bank.datasource.tools.ManagerSQL;

public class BankWebAppRunner {

	public static void main(String[] args) throws SQLException {

//       ConfigParser p = new ConfigParser("xml/db_config/config.xml");
//	
//		HikariConfig config = new HikariConfig();
//
//		config.setDriverClassName("com.mysql.jdbc.Driver");
//		config.setJdbcUrl("jdbc:mysql://localhost:3306/bd_clients?useSSL=false");
//		config.setUsername("root");
//		config.setPassword("10041995Dima");

//		HikariDataSource dataSource = new HikariDataSource(config);
//		
//		DataSourceBehavior dataSource = DataBaseManager.getInstance();
//
//		Connection c = dataSource.getConnection();
//
//		Statement st = c.createStatement();
//
//		ResultSet res = st.executeQuery("SELECT `first_name` FROM `clients`");
//
//		while (res.next()) {
//			System.out.println(res.getString(1));
//		}
//		
//		
//
//		res.close();
//		st.close();
//		
//		dataSource.closeConnection(c);
//		
//		DataBaseManager.getInstance().closeDataSource();
		
		System.out.println(ManagerSQL.getInstance().getPreparedSqlRequest("SQL_GET_USER"));
		
	

	}

}
