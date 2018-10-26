package com.zuulserver.moviezuulserver;

import com.zuulserver.moviezuulserver.filters.Errorfilter;
import com.zuulserver.moviezuulserver.filters.Postfilter;
import com.zuulserver.moviezuulserver.filters.Prefilter;
import com.zuulserver.moviezuulserver.filters.Routefilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient // for eureka to discove this application
 // to act as api gateway
public class MoviezuulserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviezuulserverApplication.class, args);
	}
	@Bean
	public Prefilter prefilter()
	{
		return new Prefilter();
	}
	@Bean
	public Postfilter postfilter()
	{
		return new Postfilter();
	}
	@Bean
	public Errorfilter errorfilter()
	{
		return new Errorfilter();
	}
	@Bean
	public Routefilter routefilter()
	{
		return new Routefilter();
	}
}
