package com.nacos.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nacos.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper extends BaseMapper<Payment> {
    int create(PaymentMapper payment);
    PaymentMapper queryById(@Param("id")long id);
}
