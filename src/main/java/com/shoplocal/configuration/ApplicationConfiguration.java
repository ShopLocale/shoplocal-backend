package com.shoplocal.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    /*    modelMapper
    .getConfiguration()
    .setFieldMatchingEnabled(true)
    .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);*/
    return modelMapper;
  }
}
