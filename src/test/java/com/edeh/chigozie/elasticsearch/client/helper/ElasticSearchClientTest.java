//package com.edeh.chigozie.elasticsearch.client.helper;
//
//import junit.framework.TestCase;
//import org.elasticsearch.client.Response;
//import org.elasticsearch.client.RestClient;
//import org.junit.Test;
//
//import java.util.Collections;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertThat;
//
//public class ElasticSearchClientTest extends TestCase {
//
//    public void setUp() throws Exception {
//        super.setUp();
//
//    }
//
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public  void testGetHTTPClient() throws Exception {
//        RestClient restClient = ElasticSearchClient.getHTTPClient("localhost", 9200);
//        assertNotNull(restClient);
//        Response response = restClient.performRequest("GET", "/ocs/_search",
//                Collections.singletonMap("column", "6"));
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//    }
//
//    @Test
//    public void testCloseConnections() throws Exception {
//        RestClient restClient = ElasticSearchClient.getHTTPClient("localhost", 9200);
//        assertNotNull(restClient);
//        ElasticSearchClient.closeConnections(restClient);
//    }
//
//
//}