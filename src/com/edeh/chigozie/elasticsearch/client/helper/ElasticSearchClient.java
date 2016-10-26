package com.edeh.chigozie.elasticsearch.client.helper;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by kingsley on 10/23/16.
 */
public class ElasticSearchClient {
    private static RestClient restClient = null;


    /*
    * Get RestClient connection to the database
    * */
    public static RestClient getHTTPClient(String ip, int port) throws UnknownHostException {
        if (restClient != null) {
            return restClient;
        }

        restClient = RestClient.builder(
                new HttpHost(ip, port, "http")).build();
        return restClient;
    }

    /*
    * Close passed in parameters
    * */
    public static void closeConnections(RestClient restClient){
        try {
            restClient.close();
        } catch (IOException ex) {
        }
    }
}
