package co.pablobastidasv.cxfjaxrs.web.expenses.vm;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import co.pablobastidasv.cxfjaxrs.web.expenses.service.ExpenseManagementService;
import co.pablobastidasv.cxfjaxrs.web.expenses.service.MoneyManagementService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by Juan on 6/24/2016.
 */
@VariableResolver(DelegatingVariableResolver.class)
public class ExpenseManagementVM {

    @WireVariable("expenseManagementService")
    private ExpenseManagementService expenseManagementService;

    @WireVariable
    private MoneyManagementService moneyManagementService;

    private String queryString;
    private ListModelList<Expense> expenses;
    private ListModelList<Currency> currencies;
    private Expense selectedExpense;
    private Currency selectedCurrency;
    private String rateCode;


    @Init
    public void init() {

        this.queryString = "";
        this.expenses = new ListModelList<>();
        this.currencies = new ListModelList<>(Currency.getAvailableCurrencies());
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
    public void changeRates() throws Exception {

        if( selectedCurrency.equals(Currency.getInstance(Locale.getDefault())) && !expenses.isEmpty()){

            expenses.forEach( (v) -> v.getNetWorth().resetMoneyConfiguration());
            expenses.forEach( (v) -> v.getTotal().resetMoneyConfiguration());
        }else{

            Locale conversionLocale = new Locale(selectedCurrency.getCurrencyCode().substring(0,2));
            Double conversionRate = moneyManagementService.findConversionRate(
                    Currency.getInstance(Locale.getDefault()).getCurrencyCode(),
                    selectedCurrency.getCurrencyCode()
            );
            expenses.forEach( (v) -> v.getNetWorth().setupMoneyConfiguration(conversionLocale, conversionRate));
            expenses.forEach( (v) -> v.getTotal().setupMoneyConfiguration(conversionLocale, conversionRate));
        }
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

    public Expense getSelectedExpense() {
        return selectedExpense;
    }

    public void setSelectedExpense(Expense selectedExpense) {
        this.selectedExpense = selectedExpense;
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

    public MoneyManagementService getMoneyManagementService() {
        return moneyManagementService;
    }

    public void setMoneyManagementService(MoneyManagementService moneyManagementService) {
        this.moneyManagementService = moneyManagementService;
    }
}
