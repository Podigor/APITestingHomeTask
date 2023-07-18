import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static rest.ApiRequest.getRest;


@RunWith(Parameterized.class)
public class FirstTest {
    String countryCode;
    String bankGovUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=";

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList("USD", "AUD", "CAD", "NZD", "CZK");
    }

    public FirstTest(String countryCode) {
        this.countryCode = countryCode;
    }

    @Test
    public void test1(){
        JSONObject jsonObject = new JSONArray(getRest(bankGovUrl + countryCode + "&json")).getJSONObject(0);
        System.out.println("r030 = " + jsonObject.getInt("r030"));
        System.out.println("txt = " + jsonObject.getString("txt"));
        System.out.println("rate = " + jsonObject.getDouble("rate"));
        System.out.println("cc = " + jsonObject.getString("cc"));
        System.out.println("exchangedate = " + jsonObject.getString("exchangedate"));
        System.out.println("------------------------------------");
    }
}
