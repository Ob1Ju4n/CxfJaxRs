package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.text.NumberFormat;
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

    public Money(){}

    public Money(Locale locale) {
        this.locale = locale;
    }

    public Money(BigDecimal amount) {

        this(Locale.getDefault());
        this.amount = amount;
        this.setDisplayValueForLocale();
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
        return this.displayValue;
    }

    public void setDisplayValueForLocale(){
        this.displayValue = NumberFormat.getCurrencyInstance(this.locale).format(this.getAmount());
    }

    public void setDisplayValueForLocale(Locale locale, Double conversionRate){
        this.displayValue = NumberFormat.getCurrencyInstance(locale).format(this.getAmount().multiply(new BigDecimal(conversionRate)));
    }

}
