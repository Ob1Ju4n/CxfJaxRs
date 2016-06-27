package co.pablobastidasv.cxfjaxrs.web.expenses.service;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Juan on 6/24/2016.
 */
@Component("expenseManagementService")
public class ExpenseManagementService {

    private int srvPort = 8080;
    final String BASE_URL = "http://localhost:" + srvPort + "/api/expenses/";
    private RestTemplate client;

    public ExpenseManagementService() {
        this.client = new TestRestTemplate();
    }

    public List<Expense> findAll(){

        ResponseEntity<Expense[]> response = client.getForEntity(BASE_URL, Expense[].class);
        List<Expense> found = Arrays.asList(response.getBody());
        return found;
    }

    public Expense findById(String id){

        ResponseEntity<Expense> response = client.getForEntity(BASE_URL + id, Expense.class);
        Expense found = response.getBody();
        return found;
    }

}
