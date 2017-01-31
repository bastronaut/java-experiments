package com.bastronaut.defaultmethods.async;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Created by Bas on 23-1-2017.
 */
public class Async {


    public static void doSyncGet() throws IOException {
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

    public static void doAsyncGet() throws IOException, ExecutionException, InterruptedException {
        CloseableHttpAsyncClient asynchttpclient = HttpAsyncClients.createDefault();

        try {
            // asnychttp client lib
            asynchttpclient.start();
//            System.out.println("started asynchttpclient");
//
//            final HttpGet getRequest = new HttpGet("http://www.google.com/search?q=httpClient");
//            Future<HttpResponse> future = asynchttpclient.execute(getRequest, null);
//            System.out.println("after setting up future");
//
//            System.out.println("getting from future");
//            HttpResponse response = future.get();
//            System.out.println("got from future");
//            System.out.println(response.getStatusLine());
//            System.out.println("got statusline");

            // now with callback
            final CountDownLatch latch = new CountDownLatch(1);
            final HttpGet getRequest2 = new HttpGet("http://www.apache.org/");
            asynchttpclient.execute(getRequest2, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    latch.countDown();
                    System.out.println("Completed!");
                    System.out.println(httpResponse.getStatusLine());
                }

                @Override
                public void failed(Exception e) {
                    latch.countDown();
                    System.out.println("Failed!");
                    System.out.println(e);
                }

                @Override
                public void cancelled() {
                    System.out.println("Cancelled!!");
                }
            });
            System.out.println("before await but after execute callbacks run");
            latch.await();

        } finally {
            asynchttpclient.close();
        }
    }
}
