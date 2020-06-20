package com.xuke.springcloud.service.Impl;

import com.xuke.springcloud.dao.PaymentMapper;
import com.xuke.springcloud.entities.Payment;
import com.xuke.springcloud.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IPaymentService implements PayMentService {

    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return paymentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentMapper.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentMapper.updateByPrimaryKey(record);
    }
}
