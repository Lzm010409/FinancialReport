package restfulapi.requests;

import entity.ExportVoucher;
import entity.Filter;
import entity.SevQuery;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import restfulapi.requests.builder.JsonBuilder;
import restfulapi.requests.url.Token;
import restfulapi.requests.url.URL;
import restfulapi.requests.url.UrlBuilder;
import time.TimeStampGenerator;

import java.io.*;
import java.util.Base64;

public class Request {
    public String httpPost(String JSON_STRING, String URL, String TOKEN) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity requestEntity = new StringEntity(
                JSON_STRING,
                ContentType.APPLICATION_JSON
        );
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setEntity(requestEntity);
        httpPost.setHeader("Authorization", TOKEN);

        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            System.out.println(response.getCode() + " " + response.getReasonPhrase());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String output = bufferedReader.readLine();
            httpclient.close();
            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public String httpPost(File file, String URL, String TOKEN) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("file", file);
        entityBuilder.setContentType(ContentType.MULTIPART_FORM_DATA);
        HttpEntity multiPartHttpEntity = entityBuilder.build();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setEntity(multiPartHttpEntity);
        httpPost.setHeader("Authorization", TOKEN);
        httpPost.setHeader("ContentType", ContentType.MULTIPART_FORM_DATA);

        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            System.out.println(response.getCode() + " " + response.getReasonPhrase());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String output = bufferedReader.readLine();
            httpclient.close();
            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public String httpGet(String JSON_STRING, String URL, String TOKEN) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity requestEntity = new StringEntity(
                JSON_STRING,
                ContentType.APPLICATION_JSON
        );
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setEntity(requestEntity);
        httpGet.setHeader("Authorization", TOKEN);

        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            System.out.println(response.getCode() + " " + response.getReasonPhrase());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String output = bufferedReader.readLine();
            //httpclient.close();
            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String httpGet(String URL, String TOKEN) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("Authorization", TOKEN);

        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            System.out.println(response.getCode() + " " + response.getReasonPhrase());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String output = bufferedReader.readLine();
            httpclient.close();
            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Request request = new Request();
        Token token = new Token();
        token.setToken("");
        SevQuery sevQuery = new SevQuery(
                "Voucher"
        );
        Filter filter = new Filter();
        TimeStampGenerator timeStampGenerator = new TimeStampGenerator();
        filter.setStartPayDate(String.valueOf(timeStampGenerator.generateTimestamp(2022, 11, 20)));
        filter.setEndPayDate(String.valueOf(timeStampGenerator.generateTimestamp(2022, 11, 30)));
        sevQuery.setFilter(filter);
        ExportVoucher exportVoucher = new ExportVoucher(sevQuery);
        exportVoucher.setDownload(true);
        String output = new JsonBuilder().build(exportVoucher);
        request.httpGet(new JsonBuilder().build(exportVoucher),new UrlBuilder().buildUrl(URL.GETVOUCHERZIP),token.getToken());
    }
}
