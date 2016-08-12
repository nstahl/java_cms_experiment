package com.java.cms.experiment;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by niko on 8/11/16.
 */
public class ElasticSearchIntegrationTest {

    // documented here https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/index.html
    private RestClient restClient;
    private String hostUrl = "1a899325e2c31027087ee0973b7433c0.us-east-1.aws.found.io";

    @Test
    public void test_ElasticSearch() throws IOException {
        restClient = RestClient.builder(new HttpHost(hostUrl,  9200)).build();

        //index a document
        HttpEntity httpEntity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"niko\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"trying out Elasticsearch\"\n" +
                        "}", ContentType.APPLICATION_JSON);

        Response indexResponse = restClient.performRequest(
                "PUT",
                "/twitter/tweet/1",
                Collections.<String, String>emptyMap(),
                httpEntity);


        Response searchResponse = restClient.performRequest(
                "GET",
                "/twitter/tweet/_search?q=user:niko");

        String jsonString = IOUtils.toString(searchResponse.getEntity().getContent(), "UTF-8");

        assertTrue(jsonString.contains("niko"));

        restClient.close();
    }

}
