package co.pablobastidas.cxfjaxrs.business.expenses.boundary.rest;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Detail;
import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import co.pablobastidasv.cxfjaxrs.business.expenses.entity.TransferType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by j.ortiz on 5/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ExpenseRestBoundaryTest {

    final String BASE_URL = "http://localhost:8080/api/expenses";
    private RestTemplate client;
    private List<Detail> details;
    private Expense e1,e2;


    @Before
    public void setup(){

        client = new TestRestTemplate();

        details = Arrays.asList(
                new Detail("Pago cuenta cobro comisiones", new BigDecimal("1335600")),
                new Detail("Retencion en la fuente 10%", new BigDecimal("150000")),
                new Detail("Retencion de ICA 9.66", new BigDecimal("14400"))
        );

        e1 = new Expense.Builder().
                id("1").
                details(details).
                netWorth(new BigDecimal("1335600")).
                total(new BigDecimal("1500000")).
                transferType(new TransferType("CSH","Cash")).
                build();

        e2 = new Expense.Builder().
                id("2").
                details(details).
                netWorth(new BigDecimal("1335600")).
                total(new BigDecimal("1500000")).
                transferType(new TransferType("CRC","Credit Card")).
                build();
    }

    @Test
    public void shouldCreateExpense(){

        ResponseEntity<Expense> response = client.postForEntity(BASE_URL, e1, Expense.class, Collections.EMPTY_MAP);
        Expense created = response.getBody();

        assertThat(created, notNullValue());
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(created.getCreationDate(), equalTo(e1.getCreationDate()));

    }

    @Test
    public void shouldReturnExpenseWithGivenId(){

        ResponseEntity<Expense> response = client.getForEntity(BASE_URL + e1.getId(), Expense.class);
        Expense found = response.getBody();

        assertThat(found, notNullValue());
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(found.getId(), equalTo(e1.getId()));

    }


}
