package co.pablobastidasv.cxfjaxrs.web.expenses.controller;

import co.pablobastidasv.cxfjaxrs.web.expenses.service.TestBean;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

/**
 * Created by j.ortiz on 5/26/2016.
 */
@VariableResolver(DelegatingVariableResolver.class)
public class IndexController {

    @WireVariable("serviceBean")
    private TestBean serviceBean;

    private String message;

    @Init
    public void init(){
        message = serviceBean.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
