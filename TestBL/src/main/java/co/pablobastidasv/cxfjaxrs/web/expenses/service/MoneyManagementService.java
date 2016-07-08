package co.pablobastidasv.cxfjaxrs.web.expenses.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;


/**
 * Created by j.ortiz on 06/07/2016.
 */
@Component("moneyManagementService")
public class MoneyManagementService {

    final String BASE_URL = "http://query.yahooapis.com/v1/public/yql?q=";
    final String query = "select * from yahoo.finance.xchange where pair in (\"%s\")";
    private RestTemplate client;


    public MoneyManagementService() {
        this.client = new TestRestTemplate();
    }

    public Double findConversionRate(String baseRate, String targetRate) throws Exception{

        String queryValue = baseRate+targetRate;
        StringBuilder encodedUrl = new StringBuilder()
                .append(BASE_URL)
                .append(URLEncoder.encode(String.format(query, queryValue), "UTF-8"))
                .append("&env=store://datatables.org/alltableswithkeys&format=json");

        URI uri = URI.create(encodedUrl.toString());
        System.out.println(uri);

        ResponseEntity<JsonNode> response = client.getForEntity(
                uri, JsonNode.class
        );

        JsonNode responseBody = response.getBody();
        JsonNode rate = responseBody.findValue("Rate");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(rate, Double.class);
    }

}
