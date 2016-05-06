package co.pablobastidasv.cxfjars.business.expenses.boundary;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by j.ortiz on 5/4/2016.
 */
@RestController
@RequestMapping("/expenses")
public class ExpenseEngine {


    // Query all expenses
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(){
        return "";
    }

    // Query a specific expense by Id
    @RequestMapping(value = "/{expenseId}", method = RequestMethod.GET)
    public String findById(@PathVariable String expenseId){
        return "Got a 'get' request for the expense with Id = " + expenseId;
    }

    // Create a new expense
    @RequestMapping(method = RequestMethod.POST)
    public String create(){
        return "Got a 'post' request to create a new expense";
    }

    // Updates a specific expense
    @RequestMapping(value = "/{expenseId}", method = RequestMethod.PUT)
    public String update(@PathVariable String expenseId){
        return "Got a 'put' request to update the expense with Id = " + expenseId;
    }

    // Deletes a specific expense
    @RequestMapping(value = "/{expenseId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String expenseId){
        return "Got a 'delete' request to delete the expense with Id = " + expenseId;
    }

}
