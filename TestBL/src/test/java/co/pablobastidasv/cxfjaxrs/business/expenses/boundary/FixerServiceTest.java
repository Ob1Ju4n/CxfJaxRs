package co.pablobastidasv.cxfjaxrs.business.expenses.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by j.ortiz on 29/06/2016.
 */
public class FixerServiceTest {

    private RestTemplate client;

    public FixerServiceTest() {
        this.client = new TestRestTemplate();
    }

    public static void main(String... args){

        FixerServiceTest sysTest = new FixerServiceTest();
        ResponseEntity<JsonNode> response = sysTest.client.getForEntity("http://api.fixer.io/latest?base=USD", JsonNode.class);
        JsonNode responseBody = response.getBody();

        System.out.println("Base: "+responseBody.get("base")+"\nDate: "+responseBody.get("date"));

        JsonNode rates = responseBody.get("rates");
        if( !rates.isNull() && rates.getNodeType().equals(JsonNodeType.OBJECT) ){

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Double> ratesMap = mapper.convertValue(rates, Map.class);
            ratesMap.forEach( (k,v) -> System.out.println(k+" : "+v) );
            /*
            for( Map.Entry<String, Double> entry : ratesMap.entrySet() ){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            */
        }
    }
}
