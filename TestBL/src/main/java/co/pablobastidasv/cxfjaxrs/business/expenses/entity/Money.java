package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
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

    public Money(){
        this.locale = Locale.getDefault();
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(Locale locale) {
        this.locale = locale;
    }

    public Money(BigDecimal amount, Locale locale) {

        this.amount = amount;
        this.locale = locale;
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
        return displayValue;
    }
}
