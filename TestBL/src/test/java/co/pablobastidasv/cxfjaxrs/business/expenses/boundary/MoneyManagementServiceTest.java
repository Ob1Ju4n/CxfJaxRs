package co.pablobastidasv.cxfjaxrs.business.expenses.boundary;

import co.pablobastidasv.cxfjaxrs.web.expenses.service.MoneyManagementService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by j.ortiz on 06/07/2016.
 */
public class MoneyManagementServiceTest {

    @Test
    public void shouldReturnRate() throws Exception{

        MoneyManagementService moneyManagementService = new MoneyManagementService();

        Double result = moneyManagementService.findConversionRate("COP","JPY");

        assertThat(result, notNullValue());
        assertThat(result, equalTo(0.0337D));
    }

}
