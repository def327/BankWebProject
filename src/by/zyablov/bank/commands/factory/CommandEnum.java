package by.zyablov.bank.commands.factory;

import by.zyablov.bank.commands.CommandAdminBlockClient;
import by.zyablov.bank.commands.CommandAdminShowProfile;
import by.zyablov.bank.commands.CommandAdminUnblockClient;
import by.zyablov.bank.commands.CommandBehavior;
import by.zyablov.bank.commands.CommandClientAddMoney;
import by.zyablov.bank.commands.CommandClientAddNewCreditCard;
import by.zyablov.bank.commands.CommandClientCreateNewBankAccount;
import by.zyablov.bank.commands.CommandClientCreateUserProfile;
import by.zyablov.bank.commands.CommandClientSpendMoney;
import by.zyablov.bank.commands.CommandUserClientRigisterNewUser;
import by.zyablov.bank.commands.CommandUserLogin;
import by.zyablov.bank.commands.CommandUserLogout;
import by.zyablov.bank.commands.CommandUserMoveToRegistryPage;

/**
 * Enum {@code CommandEnum} represents types of command to execute.
 * 
 * @author Дмитрий
 *
 */
public enum CommandEnum {

	ADMIN_BLOCK_CLIENT {
		{
			this.command = new CommandAdminBlockClient();
		}
	},

	ADMIN_SHOW_PROFILE {
		{
			this.command = new CommandAdminShowProfile();
		}
	},

	ADMIN_UNBLOCK_CLIENT {
		{
			this.command = new CommandAdminUnblockClient();
		}
	},

	CLIENT_ADD_MONEY {
		{
			this.command = new CommandClientAddMoney();
		}
	},

	CLIENT_ADD_NEW_CREDIT_CARD {
		{
			this.command = new CommandClientAddNewCreditCard();
		}
	},

	CLIENT_ADD_NEW_BANK_ACCOUNT {
		{
			this.command = new CommandClientCreateNewBankAccount();
		}
	},

	CLIENT_CREATE_USER_PROFILE {
		{
			this.command = new CommandClientCreateUserProfile();
		}
	},

	CLIENT_SHOW_PROFILE {
		{
			this.command = new CommandClientSpendMoney();
		}
	},

	CLIENT_SPEND_MONEY {
		{
			this.command = new CommandUserLogin();
		}
	},

	USER_LOGIN {
		{
			this.command = new CommandUserLogin();
		}
	},

	USER_LOGOUT {
		{
			this.command = new CommandUserLogout();
		}
	},

	USER_MOVE_REGISTRY_PAGE {
		{
			this.command = new CommandUserMoveToRegistryPage();
		}
	},

	USER_CLIENT_REGISTER_NEW_USER {
		{
			this.command = new CommandUserClientRigisterNewUser();
		}

	};

	/**
	 * A command to execute.
	 */
	CommandBehavior command;

	/**
	 * Returns a command to execute.
	 */
	public CommandBehavior getCommand() {
		return command;
	}

}
