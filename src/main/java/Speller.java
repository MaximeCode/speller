import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Speller {

    private static String url = "http://speller.yandex.net/services/spellservice";
    private static String myText = "задание по использованию API в тестировании для стажоров";

    public static void main(String[] args) {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url + "/checkText?text=" + myText.replaceAll("[ -]", "+"));
        try {
            response = client.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                response.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
