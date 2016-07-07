package co.pablobastidasv.cxfjaxrs.web.expenses.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;


/**
 * Created by j.ortiz on 06/07/2016.
 */
@Component("moneyManagementService")
public class MoneyManagementService {

    final String BASE_URL = "http://query.yahooapis.com/v1/public/yql?q=";
    //http://query.yahooapis.com/v1/public/yql?q=select * from yahoo.finance.xchange where pair in ("USDEUR", "USDJPY", "USDINR")&env=store://datatables.org/alltableswithkeys
    final String query = "select * from yahoo.finance.xchange where pair in (\"%s\")";
    private RestTemplate client;


    public MoneyManagementService() {
        this.client = new TestRestTemplate();
    }

    public Double findConversionRate(String baseRate, String targetRate) throws Exception{

        String queryValue = baseRate+targetRate;
        StringBuilder unencodedUrl = new StringBuilder()
                .append(BASE_URL)
                .append(URLEncoder.encode(String.format(query, queryValue), "UTF-8"))
                .append("&env=store://datatables.org/alltableswithkeys&format=json");

        //Since URL encoder doesn't encode asterisk, replace is needed
        String requestUrl = unencodedUrl.toString();
        System.out.println(requestUrl);

        ResponseEntity<JsonNode> response = client.getForEntity(
                requestUrl, JsonNode.class
        );

        JsonNode responseBody = response.getBody();

        JsonNode rate = responseBody.get("Rate");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(rate, Double.class);
    }

}
