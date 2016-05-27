package co.pablobastidasv.cxfjaxrs.web.service;

import org.springframework.stereotype.Component;

/**
 * Created by j.ortiz on 5/26/2016.
 */
@Component("serviceBean")
public class TestBean {

    public TestBean() {
    }

    public String getMessage(){
        return "Hello world ZK";
    }

}
