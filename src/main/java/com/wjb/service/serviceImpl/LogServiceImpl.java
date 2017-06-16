package com.wjb.service.serviceImpl;

import com.wjb.service.LogService;
import com.wjb.util.PageSupport;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by wjb on 2017/6/6.
 */
@Service
public class LogServiceImpl implements LogService {
    TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

    public LogServiceImpl() throws UnknownHostException {
    }

    /**
     * TransportClient客户端
     *
     * @return
     */
    public SearchResponse getResponse(String key, String value, String[] include, String[] exclude, String startDate, String endDate, Integer start, Integer pageSize) throws UnknownHostException {
        SearchResponse response = client.prepareSearch("job-*")
                .setTypes("job_log")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setFetchSource(include, exclude)                                      //获取指定字段
                .setQuery(QueryBuilders.matchPhraseQuery(key, value))                 // Query
                .setPostFilter(QueryBuilders.rangeQuery("@timestamp").from(startDate).to(endDate))
                .setFrom(start).setSize(pageSize)              // 分页
                .setExplain(true).addSort("@timestamp", SortOrder.ASC)
                .get();
        return response;
    }

    /**
     * 前端传的message,获取所有JobId
     *
     * @param key
     * @param value
     * @return
     * @throws UnknownHostException
     */
    @Override
    public PageSupport getJobIds(String key, String value, Integer start, Integer pageSize) throws UnknownHostException {
        String[] include = {"job_id", "@timestamp"};
        String[] exclude = {"_id", "message"};
        PageSupport pageSupport = new PageSupport();
        List<Object> list = new ArrayList<>();
        String s = "trigger_start:";
        String messageValue = s + value;
        SearchResponse response = getResponse("message", messageValue, include, exclude, null, null, start, pageSize);
        SearchHit[] hits = response.getHits().getHits();
        long totalHits = response.getHits().getTotalHits();
        for (SearchHit hit : hits) {
            System.out.println("结果" + hit.getSource().get("job_id"));
            list.add(hit.getSource());
        }
        pageSupport.setList(list);
        System.out.println("共匹配" + totalHits + "条");
        pageSupport.setCurrPageNo((start / pageSize) + 1);
        pageSupport.setPageSize(pageSize);
        pageSupport.setRecordCount((int) totalHits);
        return pageSupport;
    }


    /**
     * 获取jobId对应的所有的日志
     *
     * @param key
     * @param value
     * @param startDate
     * @param endDate
     * @return
     * @throws UnknownHostException
     */
    @Override
    public PageSupport getJobIdLog(String key, String value, String startDate, String endDate, Integer start, Integer pageSize) throws UnknownHostException {
        String[] include = {"job_id", "@timestamp", "message"};
        String[] exclude = {"_id", "type"};
        PageSupport pageSupport = new PageSupport();
        List<Object> list = new ArrayList<Object>();
        SearchResponse response = getResponse(key, value, include, exclude, startDate, endDate, start, pageSize);
        SearchHit[] hits = response.getHits().getHits();
        long totalHits = response.getHits().getTotalHits();
        for (SearchHit hit : hits) {
            list.add(hit.getSource().get("@timestamp") + "\t" + hit.getSource().get("job_id") + "\t" + hit.getSource().get("message"));
//            list.add(hit.getSource());
        }
        System.out.println("共匹配日志" + totalHits + "条");
        pageSupport.setList(list);
        pageSupport.setCurrPageNo((start / pageSize) + 1);
        pageSupport.setPageSize(pageSize);
        pageSupport.setRecordCount((int) totalHits);
        return pageSupport;
    }

    /**
     * 返回文本形式的Log
     *
     * @param key
     * @param value
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     * @throws UnknownHostException
     */
    @Override
    public PageSupport getLogText(String key, String value, String startDate, String endDate, Integer start, Integer pageSize) throws UnknownHostException {
        String[] include = {"job_id", "@timestamp", "message"};
        String[] exclude = {};
        PageSupport pageSupport = new PageSupport();
        List<Object> list = new ArrayList<Object>();
        StringBuffer buffer = new StringBuffer();
        SearchResponse response = getResponse(key, value, include, exclude, startDate, endDate, start, pageSize);
        SearchHit[] hits = response.getHits().getHits();
        long totalHits = response.getHits().getTotalHits();
        String[] obj = new String[pageSize];
//        for (SearchHit hit : hits) {
////            list.add(hit.getSource().get("@timestamp") + "\t" + hit.getSource().get("job_id") + "\t" + hit.getSource().get("message"));
////            buffer.append(hit.getSource().get("@timestamp")+""+hit.getSource().get("message")+"=====");
//        }
        for (int i = 0; i < hits.length; i++) {
            if (hits[i].getSource().get("@timestamp") != null) {
                obj[i] = hits[i].getSource().get("@timestamp") + "\t" + hits[i].getSource().get("message");
            }
        }
        System.out.println("共匹配日志" + totalHits + "条");
        pageSupport.setObj(obj);
        pageSupport.setCurrPageNo((start / pageSize) + 1);
        pageSupport.setPageSize(pageSize);
        pageSupport.setRecordCount((int) totalHits);
        return pageSupport;
    }


}
