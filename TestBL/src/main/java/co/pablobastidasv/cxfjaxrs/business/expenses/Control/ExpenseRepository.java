package co.pablobastidasv.cxfjaxrs.business.expenses.control;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * Created by Juan on 5/6/2016.
 */
public interface ExpenseRepository  extends PagingAndSortingRepository<Expense, String> {
    List<Expense> findAll();
}
