package com.edeh.chigozie.elasticsearch.client.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/**
 * Created by kingsley on 10/23/16.
 */
public class ElasticSearchCRUD {
    public static Response createRecord(Object object, RestClient restClient, String documentName) throws UnknownHostException, JsonProcessingException {
        HttpEntity entity = new NStringEntity(getJson(object), ContentType.APPLICATION_JSON);
        Response indexResponse = null;
        try {
            indexResponse = restClient.performRequest(
                    "PUT",
                    "/ocs/" + documentName +"/" + UUID.randomUUID().toString(),
                    Collections.<String, String>emptyMap(),
                    //assume that the documents are stored in an entities array
                    entity
            );
        } catch (IOException ex) {
        }
        return indexResponse;
    }

    private static String getJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
            jsonString = mapper.writeValueAsString(object);

        return jsonString;
    }

    public static Response search(RestClient restClient, String key, String value) throws IOException {
        Response response = null;
            response = restClient.performRequest("GET", "/ocs/_search",
                    Collections.singletonMap(key, value));

        return response;
    }
}
