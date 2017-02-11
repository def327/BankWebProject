package by.zyablov.bank.commands.factory;

import by.zyablov.bank.commands.CommandBehavior;
import by.zyablov.bank.commands.CommandEmpty;

/**
 * Class {@code CommandFactory} provides method to create
 * {@code CommandBehavior} objects.
 * 
 * @author Дмитрий
 * 
 * @see CommandBehavior
 *
 */
public class CommandFactory {

	/**
	 * Create a {@code CommandBehavior} object.
	 * 
	 * @param commandType
	 *            A name of command to create
	 * 
	 * @return A concrete command
	 */
	public CommandBehavior createCommand(String commandType) {

		if (commandType == null | commandType.isEmpty()) {
			return new CommandEmpty();
		}

		CommandEnum currentCommandEnum = CommandEnum.valueOf(commandType.toUpperCase());
		CommandBehavior currentCommand = currentCommandEnum.getCurrentCommand();

		return currentCommand;

	}

}
