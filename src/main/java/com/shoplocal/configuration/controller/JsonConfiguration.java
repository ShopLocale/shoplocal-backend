package com.shoplocal.configuration.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Configuration
@EnableWebMvc
public class JsonConfiguration implements WebMvcConfigurer {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter jacksonMessageConverter =
        new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();

    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    objectMapper.enable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

    objectMapper.configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, true);
    objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);

    converters.add(jacksonMessageConverter);
  }
}
