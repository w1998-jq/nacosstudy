package com.nacos.consumer.controller;

import com.nacos.common.pojo.CommonResult;
import com.nacos.common.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@Slf4j
public class ConsumerController {


    public static final  String PAYMENT_URL = "http://localhost:9091";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = provider.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        return restTemplate.getForObject("http://" + host + ":" + port+"/payment/get/"+id,CommonResult.class);
    }

    public Payment selectInfo(int id){
        return null;
    }

}
