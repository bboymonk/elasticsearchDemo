//package com.wjb.util;
//
//import com.wjb.bean.JobLog;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.annotations.Query;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by wjb on 2017/6/13.
// */
//@Repository
//public interface JobLogRepository extends ElasticsearchRepository<JobLog,String> {
//    @Query("{\"query\":{\"bool\" : {\"must\" : {\"match\" : {\"job_id\" : \"?0\"}}}}}")
//    List<JobLog> findByJob_id(String jobId);
//
//    @Query("{\"query\":{\"bool\" : {\"must\" : {\"match\" : {\"message\" : \"?0\"}}}}}")
//    List<JobLog> findByMessage(String message);
//    //@Query("{\"query\":{\"bool\":{\"must\":[{\"match\":{\"userId\":\"?0\"}},{\"nested\":{\"path\":\"questions\",\"query\":{\"bool\":{\"must\":[{\"match\":{\"questions.id\":\"?1\"}}]}}}}]}}}")
//    @Query("{\"query\":{\"bool\" : {\"must\" : {\"match\" : {\"level\" : \"?0\"}}}}}")
//    Page<JobLog> findByLevel(String level, Pageable pageable);
//    @Query("{\"query\":{\"bool\" : {\"must\" : {\"match\" : {\"HOSTNAME\" : \"?0\"}}}}}")
//    List<JobLog> findByHostname(String hostname);
//}
