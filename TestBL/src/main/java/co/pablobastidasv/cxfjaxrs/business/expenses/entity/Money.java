package co.pablobastidasv.cxfjaxrs.business.expenses.entity;

import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Created by Juan on 6/07/2016.
 */
public class Money {

    private BigDecimal amount;

    @Transient
    private static Map<String, String> defaultSymbols;

    @Transient
    private Currency currency;

    @Transient
    private String displayValue;

    @Transient
    private Double conversionRate;

    public Money(){

        Locale[] locales = Locale.getAvailableLocales();
        defaultSymbols = new HashMap<>();

        for( Locale locale : locales ){
            if( !locale.getCountry().isEmpty() ){

                Currency currency = Currency.getInstance(locale);
                defaultSymbols.putIfAbsent(currency.getCurrencyCode(), currency.getSymbol(locale));
            }
        }

        this.conversionRate = 1D;
        this.currency = Currency.getInstance(Locale.getDefault());
    }

    public Money(Currency currency) {

        this();
        this.currency = currency;
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

    public Currency getCurrency() {
        return currency;
    }

    public String getDisplayValue() {

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(this.currency);
        DecimalFormatSymbols df = new DecimalFormatSymbols();
        df.setCurrencySymbol(defaultSymbols.get(this.currency.getCurrencyCode()));
        ((DecimalFormat) nf).setDecimalFormatSymbols(df);
        this.displayValue =  nf.format(this.getAmount().multiply(new BigDecimal(this.conversionRate)));
        return this.displayValue;
    }

    public void resetMoneyConfiguration(){

        this.conversionRate = 1D;
        this.currency = Currency.getInstance(Locale.getDefault());
    }

    public void setupMoneyConfiguration(Currency currency, Double conversionRate){

        this.conversionRate = conversionRate;
        this.currency = currency;
    }

}
