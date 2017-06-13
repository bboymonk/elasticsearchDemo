package com.wjb.service.serviceImpl;

import com.wjb.service.UrlService;
import org.springframework.stereotype.Service;

/**
 * Created by wjb on 2017/6/6.
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Override
    public String getUrl(String jobId) {
        String OriUrl = "http://localhost:5601/app/kibana#/discover?_g=()&_a=(columns:!(job_id,'@timestamp',message),index:'job-*',interval:auto,query:(query_string:(analyze_wildcard:!t,query:"+jobId+")),sort:!(_score,desc))";
        return OriUrl;
    }
}
