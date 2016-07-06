package co.pablobastidasv.cxfjaxrs.business.expenses.boundary;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Money;

import java.math.BigDecimal;

/**
 * Created by Juan on 6/07/2016.
 */
public class MoneyTest {

    public static void main(String... args){

        Money money = new Money(new BigDecimal("1130000"));
        System.out.println(money.getDisplayValue());

    }

}
