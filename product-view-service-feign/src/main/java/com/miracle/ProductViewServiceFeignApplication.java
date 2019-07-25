package com.miracle;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient
//注解多了个 @EnableDiscoveryClient， 表示用于发现eureka注册中心的微服务
@EnableDiscoveryClient
//表示用于使用 Feign 方式
@EnableFeignClients
public class ProductViewServiceFeignApplication {

	public static void main(String[] args) {
		int port = 8020;
		if(!NetUtil.isUsableLocalPort(port)) {
			System.err.printf("端口%d被占用了，无法启动%n", port );
			System.exit(1);
		}
		new SpringApplicationBuilder(ProductViewServiceFeignApplication.class).properties("server.port=" + port).run(args);

	}

//	用 restTemplate 这个工具来做负载均衡
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    加入 zipkin 服务链路
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
