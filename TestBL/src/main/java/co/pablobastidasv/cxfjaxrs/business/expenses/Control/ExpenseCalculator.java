package co.pablobastidasv.cxfjaxrs.business.expenses.control;

import co.pablobastidasv.cxfjaxrs.business.expenses.entity.Detail;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by j.ortiz on 5/10/2016.
 */
@Service
public class ExpenseCalculator {

    public BigDecimal computeExpenseTotal(List<Detail> details){

        /*BigDecimal total = BigDecimal.ZERO;
        if( !details.isEmpty() ){

            for(Detail detail: details){
                total = total.add(detail.getValue());
            }
        }

        return total;*/
        return null;
    }

}
