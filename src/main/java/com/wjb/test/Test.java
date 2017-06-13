//package com.wjb.test;
//
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
///**
// * Created by wjb on 2017/6/5.
// */
//public class Test {
//    public static void main(String[] args) throws UnknownHostException {
////        Settings settings = Settings.builder()
////                .put("cluster.name", "elasticsearch").build();
////        TransportClient client = new PreBuiltTransportClient(settings)
////                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
////                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
//////		GetResponse response = client.prepareGet("job-*", "message", "Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@592cf68]").get();
////
////
////        SearchResponse response = client.prepareSearch("job-*")
////                .setTypes("job_log")
////                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
////                .setQuery(QueryBuilders.termQuery("message", "Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@592cf68]"))                 // Query
//////				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
////                .setFrom(0).setSize(60).setExplain(true)
////                .get();
////
////        System.out.println(response.getHits().getHits().length);
//
//
//
//        Settings settings = Settings.settingsBuilder().build();
//        Client client = TransportClient.builder().settings(settings).build()
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//                //端口号有时是9300,有时是9200，具体需要查看启动elasticsearch的log信息中的transport值
////索引是bjcom
//        SearchResponse response = client.prepareSearch("bjcom")
////type是employee
//                .setTypes("employee")
//                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
////注意字段需要全部为小写，因为不区分大小写
//                .setQuery(QueryBuilders.termQuery("first_name","john"))             // Query
//                .setPostFilter(QueryBuilders.rangeQuery("age").from(1).to(30))     // Filter，分页大小
//                .setFrom(0).setSize(60).setExplain(true)
//                .execute()
//                .actionGet();
//        SearchHits hits = response.getHits();
//        SearchHit[] hits1 = hits.getHits();
//        for(SearchHit hit : hits1){
//            //返回的json字符串
//            System.out.println("結果："+hit.getSourceAsString());
//        }
//    }
//
//
//
//
//
//}
