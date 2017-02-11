package by.zyablov.bank.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import by.zyablov.bank.xml.ConfigParser;

/**
 * Class {@code DataBaseManager} provides methods to work with connections to
 * database.
 * 
 * <p>
 * Class {@code DataBaseManager} uses a
 * <a href="https://github.com/brettwooldridge/HikariCP">HikariCP connection
 * pool</a>.
 * 
 * <p>
 * Class {@code ConfigParser} load a default configuration for HikariCP
 * connection pool from XML file using StAX parser.
 * 
 * @author Дмитрий
 * 
 * @see ConfigParser
 *
 */
public class DataBaseManager implements DataSourceBehavior {

	/**
	 * An instance of {@code DataBaseManager} object.
	 */
	private static volatile DataBaseManager dataBaseManager;

	/**
	 * A maximum pool size of connection pool.
	 */
	private static final String DATA_SOURCE_MAX_POOL_SIZE = "dataSource.maxPoolSize";

	/**
	 * A password to data base.
	 */
	private static final String DATA_SOURCE_PASSWORD = "dataSource.password";

	/**
	 * An user's name of data base.
	 */
	private static final String DATA_SOURCE_USER = "dataSource.user";

	/**
	 * An URL of data base.
	 */
	private static final String DATA_SOURCE_URL = "dataSource.url";

	/**
	 * A name of driver class to load for data base connection.
	 */
	private static final String DATA_SOURCE_DRIVER_CLASS_NAME = "dataSource.driverClassName";

	/**
	 * A name of path to XML file document.
	 */
	private static final String PATH_TO_XML_FILE = "config_xml/db_config/config.xml";

	/**
	 * HikariCP pooled data source.
	 */
	private HikariDataSource dataSource;

	/**
	 * Return's an instance of {@code DataBaseManager} object.
	 * 
	 * @return A {@code DataBaseManager} object.
	 */
	public static DataBaseManager getInstance() {

		DataBaseManager localInstance = dataBaseManager;

		if (localInstance == null) {

			synchronized (DataBaseManager.class) {
				localInstance = dataBaseManager;

				if (localInstance == null) {
					dataBaseManager = localInstance = new DataBaseManager();
				}
			}
		}
		return localInstance;
	}

	/**
	 * Return's a proxy connection to database.
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

	/**
	 * Return's a proxy connetion to connection pool.
	 */
	@Override
	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}

	/**
	 * Initializes a data config by parsed configuration from XML file.
	 * 
	 * @return a data config for data source
	 * 
	 * @throws NumberFormatException
	 */
	private HikariConfig initDataSourceConfig() throws NumberFormatException {

		ConfigParser configParser = new ConfigParser(PATH_TO_XML_FILE);
		HashMap<String, String> configProperties = configParser.getProperties();

		HikariConfig config = new HikariConfig();

		config.setDriverClassName(configProperties.get(DATA_SOURCE_DRIVER_CLASS_NAME));
		config.setJdbcUrl(configProperties.get(DATA_SOURCE_URL));
		config.setUsername(configProperties.get(DATA_SOURCE_USER));
		config.setPassword(configProperties.get(DATA_SOURCE_PASSWORD));
		config.setMaximumPoolSize(Integer.parseInt(configProperties.get(DATA_SOURCE_MAX_POOL_SIZE)));

		return config;
	}

	/**
	 * Constructs and initializes by {@code ConfigParser} a
	 * {@code DataBaseManager} object.
	 * 
	 * @see ConfigParser
	 */
	private DataBaseManager() {
		this.dataSource = new HikariDataSource((HikariConfig) initDataSourceConfig());
	}

	/**
	 * Shutdown a connection pool.
	 */
	public void closeDataSource() {
		this.dataSource.close();
	}

}
