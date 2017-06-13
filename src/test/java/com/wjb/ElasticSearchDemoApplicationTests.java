package com.wjb;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchDemoApplicationTests {

	@Test
	public void contextLoads() throws UnknownHostException {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

		SearchResponse response = client.prepareSearch("job-*")
				.setTypes("job_log")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.termQuery("_id", "AVxogACLIyY6roJEErZm"))                 // Query
//				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
				.setFrom(0).setSize(60).setExplain(true)
				.get();
		SearchHit[] hits = response.getHits().getHits();
		System.out.println("===========================开始");
		for (SearchHit hit:hits){
			System.out.println("=====================结果"+hit.getSource().get("job_id"));
		}
	}

	@Test
	public void test() throws UnknownHostException {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

		SearchResponse response = client.prepareSearch("job-*")
				.setTypes("job_log")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.matchQuery("message", "Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@556214ee]"))                 // Query
//				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
				.setFrom(0).setSize(60).setExplain(true)
				.get();
		SearchHit[] hits = response.getHits().getHits();
		System.out.println("===========================开始");
		for (SearchHit hit:hits){
			System.out.println("=====================结果"+hit.getSource().get("job_id"));
		}

	}




}
