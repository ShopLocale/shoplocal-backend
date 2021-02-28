package com.shoplocal.configuration.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Date: 26/12/20
 *
 * @author Kushal Roy
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.shoplocal.repository")
public class DatabaseConfiguration {}
