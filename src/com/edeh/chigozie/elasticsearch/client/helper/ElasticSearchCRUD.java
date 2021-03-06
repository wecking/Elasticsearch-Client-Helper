package com.edeh.chigozie.elasticsearch.client.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/**
 * Created by kingsley on 10/23/16.
 */
public class ElasticSearchCRUD {


    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithObject(Object object, RestClient restClient, String schema, String documentName) throws UnknownHostException, JsonProcessingException {
        HttpEntity entity = new NStringEntity(getJson(object), ContentType.APPLICATION_JSON);
        Response indexResponse = null;
        try {
            indexResponse = restClient.performRequest(
                    "PUT",
                    "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                    Collections.<String, String>emptyMap(),
                    //assume that the documents are stored in an entities array
                    entity
            );
        } catch (IOException ex) {
        }
        return indexResponse;
    }


    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithObject(Object object, RestClient restClient, String schema, String documentName, Header... headers) throws IOException {
        HttpEntity entity = new NStringEntity(getJson(object), ContentType.APPLICATION_JSON);
        Response  indexResponse = restClient.performRequest(
                "PUT",
                "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                Collections.<String, String>emptyMap(),
                //assume that the documents are stored in an entities array
                entity, headers
        );

        return indexResponse;
    }


    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithObject(Object object, RestClient restClient, String schema, String documentName,
                                                      HttpAsyncResponseConsumer<HttpResponse> responseConsumer, Header... headers) throws IOException {
        HttpEntity entity = new NStringEntity(getJson(object), ContentType.APPLICATION_JSON);
        Response  indexResponse = restClient.performRequest(
                "PUT",
                "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                Collections.<String, String>emptyMap(),
                //assume that the documents are stored in an entities array
                entity, responseConsumer, headers
        );

        return indexResponse;
    }


    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithJsonString(String jsonString, RestClient restClient, String schema, String documentName) throws IOException {
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response  indexResponse = restClient.performRequest(
                    "PUT",
                    "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                    Collections.<String, String>emptyMap(),
                    //assume that the documents are stored in an entities array
                    entity
            );

        return indexResponse;
    }


    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithJsonString(String jsonString, RestClient restClient, String schema, String documentName, Header... headers) throws IOException {
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response  indexResponse = restClient.performRequest(
                "PUT",
                "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                Collections.<String, String>emptyMap(),
                //assume that the documents are stored in an entities array
                entity, headers
        );

        return indexResponse;
    }

    /*
    * takes parameter and persist to the elasticsearch database
    * */
    public static Response createRecordWithJsonString(String jsonString, RestClient restClient, String schema, String documentName,
                                                      HttpAsyncResponseConsumer<HttpResponse> responseConsumer, Header... headers) throws IOException {
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response  indexResponse = restClient.performRequest(
                "PUT",
                "/"+ schema+"/" + documentName +"/" + UUID.randomUUID().toString(),
                Collections.<String, String>emptyMap(),
                //assume that the documents are stored in an entities array
                entity, responseConsumer, headers
        );

        return indexResponse;
    }

    /*
    * Convert Java object to json string
    * */
    private static String getJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String  jsonString = mapper.writeValueAsString(object);

        return jsonString;
    }


    /*
    * Search the elasticsearch database
    * */
    public static Response search(RestClient restClient, String schema, String key, String value) throws IOException {
        Response response = restClient.performRequest("GET", "/"+schema+"/_search",
                    Collections.singletonMap(key, value));

        return response;
    }


}
