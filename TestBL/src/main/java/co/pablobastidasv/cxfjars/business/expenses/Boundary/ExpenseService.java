package co.pablobastidasv.cxfjars.business.expenses.boundary;

import co.pablobastidasv.cxfjars.business.expenses.entity.Expense;

import java.util.List;

/**
 * Created by j.ortiz on 5/5/2016.
 */
public interface ExpenseService {

    List<Expense> findAll();

    Expense create(Expense expense);

    Expense findById(String expenseId);

    Expense update();

    Expense delete();

}
