package com.nacos.provider.controller;

import com.nacos.common.pojo.CommonResult;
import com.nacos.common.pojo.Payment;
import com.nacos.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProviderController {

    @Autowired
    private ProviderService paymentService;

    @Value("${server.port}")
    private int serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment dept){
        boolean save = paymentService.save(dept);
        if(save){
            log.info("***************插入成功*******");
            return new CommonResult(200,"插入数据库成功"+serverPort,null);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")

    public CommonResult queryById(@PathVariable("id") Long id){

        log.info("***************进来了*********");
        Payment payment = paymentService.getById(id);
        if(payment!=null){
            log.info("***************查询成功*********"+payment);
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }

    //获取服务信息
    @GetMapping("/hello/{id}")
    public  String returnHello(){
        return "world";
    }

    public Payment selectById(){
        return null;
    }
}
