package com.nacos.provider.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nacos.common.pojo.Payment;
import com.nacos.provider.dao.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements ProviderService{
}
