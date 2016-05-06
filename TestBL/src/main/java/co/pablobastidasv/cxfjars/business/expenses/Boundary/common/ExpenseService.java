package co.pablobastidasv.cxfjars.business.expenses.boundary.common;

import co.pablobastidasv.cxfjars.business.expenses.entity.Expense;

import java.util.List;

/**
 * Created by j.ortiz on 5/5/2016.
 */
public interface ExpenseService {

    /**
     * Query all expenses
     * @return The expenses found. Empty if no expenses are found.
     */
    List<Expense> findAll();

    /**
     * Create a new expense
     * @param expense The expense to add to the db
     * @return The created expense
     */
    Expense create(Expense expense);

    /**
     * Query a specific expense by Id
     * @param expenseId The filter to use qhen querying for the specific expense
     * @return The expense associated to the filter param
     */
    Expense findById(String expenseId);

    /**
     * Updates a specific expense
     * @return The updated expense
     */
    Expense update();

    /**
     * Deletes a specific expense
     * @return The deleted expense
     */
    Expense delete();

}
