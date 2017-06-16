package com.wjb.configuration;

import com.wjb.util.ViewFreeMarker;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;


/**
 * Created by wjb on 2017/6/16.
 */
@Component
public class FreeMarkerConfig {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Bean
    public Configuration getFreeMarkerConfiguration(){
        return freeMarkerConfigurer.getConfiguration();
    }

    public void resolveMap(Map<String,String> model, String templateName){
        try {
            Template template = this.getFreeMarkerConfiguration().getTemplate(templateName);
            template.setDateFormat("yyyy-MM-dd HH:mm:ss");
            template.setDateFormat("yyyy-MM-dd");
            template.setTimeFormat("HH:mm:ss");
            template.process(model, new OutputStreamWriter(System.out));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public FreeMarkerViewResolver getFreeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver= new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setViewClass(new ViewFreeMarker().getClass());
        return freeMarkerViewResolver;
    }


}
