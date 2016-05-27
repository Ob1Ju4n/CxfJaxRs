package co.pablobastidasv.cxfjaxrs.boot;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by j.ortiz on 5/26/2016.
 */
@Configuration
public class ZKConfiguration {

    @Bean
    public DHtmlLayoutServlet dispatcherLayoutServlet(){
        return new DHtmlLayoutServlet();
    }

    @Bean
    public DHtmlUpdateServlet dispatcherUpdateServlet(){
        return new DHtmlUpdateServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherLayoutServletRegistration(){

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherLayoutServlet(), "*.zul");

        Map<String, String> params = new HashMap<>();
        params.put("update-uri","/zkau");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setInitParameters(params);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean dispatcherUpdateServletRegistration(){

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherUpdateServlet(), "/zkau/*");

        Map<String, String> params = new HashMap<>();
        params.put("update-uri","/zkau/*");
        registrationBean.setLoadOnStartup(2);
        registrationBean.setInitParameters(params);
        return registrationBean;
    }

}
