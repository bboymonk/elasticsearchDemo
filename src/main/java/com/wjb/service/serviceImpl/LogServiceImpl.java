package com.wjb.service.serviceImpl;

import com.wjb.service.LogService;
import javafx.scene.control.Pagination;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
     * @return
     */
    public SearchResponse getResponse(String key,String value,String startDate,String endDate,Integer start,Integer pageSize) throws UnknownHostException {
        SearchResponse response = client.prepareSearch("job-*")
                .setTypes("job_log")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchPhraseQuery(key, value))                 // Query
				.setPostFilter(QueryBuilders.rangeQuery("@timestamp").from(startDate).to(endDate))
//                .setScroll(TimeValue.timeValueMinutes(1))
                .setFrom(start).setSize(pageSize)              // Filter
                .setExplain(true).addSort("@timestamp", SortOrder.ASC)
                .get();
        return response;
    }

    /**
     * 前端传的message,获取所有JobId
     * @param key
     * @param value
     * @return
     * @throws UnknownHostException
     */
    @Override
    public List<Object> getJobIds(String key, String value) throws UnknownHostException {
        List<Object> list = new ArrayList<>();
        String s = "trigger_start:";
        String messageValue = s+value;
        SearchResponse response = getResponse("message", messageValue,null,null,null,null);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println("结果"+hit.getSource().get("job_id"));
            list.add(hit.getSource().get("job_id")+"\t"+hit.getSource().get("@timestamp"));
        }
        return list;
    }


    /**
     * 获取jobId对应的所有的日志
     * @param key
     * @param value
     * @param startDate
     * @param endDate
     * @return
     * @throws UnknownHostException
     */
    @Override
    public List<Object> getJobIdLog(String key, String value, String startDate, String endDate,Integer start,Integer pageSize) throws UnknownHostException {
        List<Object> list = new ArrayList<Object>();
        SearchResponse response = getResponse(key, value, startDate, endDate,start,pageSize);
            SearchHit[] hits = response.getHits().getHits();
            for (SearchHit hit:hits){
                list.add(hit.getSource().get("@timestamp") + "\t" + hit.getSource().get("job_id") + "\t" + hit.getSource().get("message"));
            }
        System.out.println("共匹配日志"+list.size()+"条");
        return list;
    }




}
