//package com.edeh.chigozie.elasticsearch.client.helper;
//
//import junit.framework.TestCase;
//import org.elasticsearch.client.Response;
//import org.elasticsearch.client.RestClient;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertThat;
//
//public class ElasticSearchCRUDTest extends TestCase {
//
//    public void testCreateRecordWithObject() throws Exception {
//        Songs songs = new Songs();
//        songs.setTitle("love of my heart");
//        RestClient restClient = ElasticSearchClient.getHTTPClient("localhost", 9200);
//        Response response = ElasticSearchCRUD.createRecordWithObject(songs, restClient, "music", "songs");
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(201));
//    }
//
//    public void testCreateRecordWithObject1() throws Exception {
//        Songs songs = new Songs();
//        songs.setTitle(" true love");
//        RestClient restClient = ElasticSearchClient.getHTTPClient("localhost", 9200);
//        Response response = ElasticSearchCRUD.createRecordWithObject(songs, restClient, "music", "songs");
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(201));
//    }
//
//
//
//    public void testSearch() throws Exception {
//        Songs songs = new Songs();
//        songs.setTitle(" true love");
//        RestClient restClient = ElasticSearchClient.getHTTPClient("localhost", 9200);
//        Response response = ElasticSearchCRUD.search(restClient, "music", "songs", "love of my heart");
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//    }
//}