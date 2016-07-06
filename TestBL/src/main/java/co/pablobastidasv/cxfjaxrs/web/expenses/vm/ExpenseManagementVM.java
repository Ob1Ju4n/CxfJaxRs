package co.pablobastidasv.cxfjaxrs.web.expenses.vm;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import co.pablobastidasv.cxfjaxrs.web.expenses.service.ExpenseManagementService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

/**
 * Created by Juan on 6/24/2016.
 */
@VariableResolver(DelegatingVariableResolver.class)
public class ExpenseManagementVM {

    @WireVariable("expenseManagementService")
    private ExpenseManagementService expenseManagementService;

    private String queryString;
    private ListModelList<Expense> expenses;
    private Expense selected;
    private String rateCode;


    @Init
    public void init() {

        this.queryString = "";
        this.expenses = new ListModelList<>();
    }

    @Command
    @NotifyChange("expenses")
    public void search(){

        queryString = queryString.trim();

        if( queryString.isEmpty() ){
            expenses.addAll(expenseManagementService.findAll());
        }else {
            expenses.clear();
            expenses.add(expenseManagementService.findById(queryString));
        }

    }

    @Command
    @NotifyChange("expenses")
    public void changeRates(){

    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public ListModelList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ListModelList<Expense> expenses) {
        this.expenses = expenses;
    }

    public Expense getSelected() {
        return selected;
    }

    public void setSelected(Expense selected) {
        this.selected = selected;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public ExpenseManagementService getExpenseManagementService() {
        return expenseManagementService;
    }

    public void setExpenseManagementService(ExpenseManagementService expenseManagementService) {
        this.expenseManagementService = expenseManagementService;
    }
}
