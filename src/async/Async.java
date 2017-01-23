package async;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Created by Bas on 23-1-2017.
 */
public class Async {


    public static void doGet() throws IOException {
        String url = "http://www.google.com/search?q=httpClient";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        request.addHeader("User-Agent", USER_AGENT);
        System.out.println("pre execute");
        HttpResponse response = client.execute(request);
        System.out.println("post execute");

        System.out.println("Response code" + response.getStatusLine().getStatusCode());
        System.out.println("post getting reponse code");

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        System.out.println("created buffered reader");

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
//            System.out.println(line);
        }
        System.out.println("done");

    }
}
