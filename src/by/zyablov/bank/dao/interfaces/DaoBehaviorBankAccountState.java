package by.zyablov.bank.dao.interfaces;

import java.util.List;

import by.zyablov.bank.beans.BankAccountState;
import by.zyablov.bank.exceptions.DaoException;

public interface DaoBehaviorBankAccountState {

	BankAccountState getBankAccountState(int bankAccountStateId) throws DaoException;

	List<BankAccountState> getListOfBankAccountStates() throws DaoException;

}
