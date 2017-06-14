package com.wjb.bean;


import java.util.Date;

/**
 * Created by wjb on 2017/6/13.
 */
public class JobLog {
    private String id;
    private Date timestamp;
    private String version;
    private String host;
    private String hostname;
    private String caller_file_name;
    private String caller_class_name;
    private String caller_method_name;
    private String caller_line_number;
    private String job_id;
    private String job_key;
    private String stack_id;
    private String trigger_key;
    private String level;
    private Integer level_value;
    private String logger_name;
    private String message;
    private String path;
    private String thread_name;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getCaller_file_name() {
        return caller_file_name;
    }

    public void setCaller_file_name(String caller_file_name) {
        this.caller_file_name = caller_file_name;
    }

    public String getCaller_class_name() {
        return caller_class_name;
    }

    public void setCaller_class_name(String caller_class_name) {
        this.caller_class_name = caller_class_name;
    }

    public String getCaller_method_name() {
        return caller_method_name;
    }

    public void setCaller_method_name(String caller_method_name) {
        this.caller_method_name = caller_method_name;
    }

    public String getCaller_line_number() {
        return caller_line_number;
    }

    public void setCaller_line_number(String caller_line_number) {
        this.caller_line_number = caller_line_number;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_key() {
        return job_key;
    }

    public void setJob_key(String job_key) {
        this.job_key = job_key;
    }

    public String getStack_id() {
        return stack_id;
    }

    public void setStack_id(String stack_id) {
        this.stack_id = stack_id;
    }

    public String getTrigger_key() {
        return trigger_key;
    }

    public void setTrigger_key(String trigger_key) {
        this.trigger_key = trigger_key;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getLevel_value() {
        return level_value;
    }

    public void setLevel_value(Integer level_value) {
        this.level_value = level_value;
    }

    public String getLogger_name() {
        return logger_name;
    }

    public void setLogger_name(String logger_name) {
        this.logger_name = logger_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getThread_name() {
        return thread_name;
    }

    public void setThread_name(String thread_name) {
        this.thread_name = thread_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JobLog{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", version='" + version + '\'' +
                ", host='" + host + '\'' +
                ", hostname='" + hostname + '\'' +
                ", caller_file_name='" + caller_file_name + '\'' +
                ", caller_class_name='" + caller_class_name + '\'' +
                ", caller_method_name='" + caller_method_name + '\'' +
                ", caller_line_number='" + caller_line_number + '\'' +
                ", job_id='" + job_id + '\'' +
                ", job_key='" + job_key + '\'' +
                ", stack_id='" + stack_id + '\'' +
                ", trigger_key='" + trigger_key + '\'' +
                ", level='" + level + '\'' +
                ", level_value=" + level_value +
                ", logger_name='" + logger_name + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", thread_name='" + thread_name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
