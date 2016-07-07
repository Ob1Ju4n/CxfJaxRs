package co.pablobastidasv.cxfjaxrs.business.expenses.boundary;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Juan on 6/07/2016.
 */
public class MoneyTest {

    public static void main(String... args){

        /*Money money = new Money("1130000");
        System.out.println("Formatted value: "+money.getDisplayValue()+"\nReal value: "+money.getAmount());

        //Simulating a request for converting COP to JPY:
        money.setupMoneyConfiguration(Locale.JAPAN, 0.0337);
        System.out.println("Formatted value: "+money.getDisplayValue()+"\nReal value: "+money.getAmount());

        money.resetMoneyConfiguration();
        System.out.println("Formatted value: "+money.getDisplayValue()+"\nReal value: "+money.getAmount());*/

        System.out.println(Currency.getAvailableCurrencies());
        Currency selectedCurrency = Currency.getInstance("JPY");
        String ISO3166 = selectedCurrency.getCurrencyCode().substring(0,2);
        System.out.println(ISO3166);
        Locale conversionLocale = new Locale(ISO3166);
    }

}
