package co.pablobastidasv.cxfjaxrs.business.expenses.boundary;

import co.pablobastidasv.cxfjaxrs.business.expenses.control.common.ExpenseRepository;
import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by j.ortiz on 5/5/2016.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseRestService {

    @Autowired
    private ExpenseRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Expense>> findAll() {

        List<Expense> expenses = repository.findAll();

        if (expenses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Expense> findById(@PathVariable("id") String id) {

        Expense expense = repository.findOne(id);

        if(expense == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {

        Expense saved = repository.save(expense);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Expense> update(@RequestBody Expense expense, @PathVariable("id") String id) {

        if( repository.exists(id) ){

            Expense updated = repository.save(expense);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Expense> delete(@PathVariable("id") String id) {

        if(repository.exists(id)){

            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
