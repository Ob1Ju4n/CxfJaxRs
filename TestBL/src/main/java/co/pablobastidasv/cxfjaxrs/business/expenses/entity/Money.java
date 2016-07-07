package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Juan on 6/07/2016.
 */
public class Money {

    private BigDecimal amount;

    @Transient
    private Locale locale;

    @Transient
    private String displayValue;

    @Transient
    private Double conversionRate;

    public Money(){
        this.conversionRate = 1D;
        this.locale = Locale.getDefault();
    }

    public Money(Locale locale) {

        this();
        this.locale = locale;
    }

    public Money(String amount) {

        this();
        this.amount = new BigDecimal(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getDisplayValue() {

        this.displayValue = NumberFormat.getCurrencyInstance(this.locale).format(this.getAmount().multiply(new BigDecimal(this.conversionRate)));
        return this.displayValue;
    }

    public void resetMoneyConfiguration(){

        this.conversionRate = 1D;
        this.locale = Locale.getDefault();
    }

    public void setupMoneyConfiguration(Locale locale, Double conversionRate){

        this.conversionRate = conversionRate;
        this.locale = locale;
    }

}
