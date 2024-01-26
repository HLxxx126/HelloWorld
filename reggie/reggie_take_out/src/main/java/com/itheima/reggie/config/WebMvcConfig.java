package com.itheima.reggie.config;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.itheima.reggie.common.JacksonObjectMapper;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射...");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }
    /**
     * メッセージ変換器を拡張する
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    	log.info("メッセージ変換器を拡張する");
    	//メッセージ変換器を構築する
    	MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
    	//具体的なオブジェクトマッパーを設定する
    	messageConverter.setObjectMapper(new JacksonObjectMapper());
    	//インデックスを設定して、このコンバーターが先頭に配置されるようにし、或いはデフォルトのJacksonコンバーターが使用されます
    	converters.add(0,messageConverter);
    }
}
