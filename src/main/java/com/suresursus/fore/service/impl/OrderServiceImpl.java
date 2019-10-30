package com.suresursus.fore.service.impl;

import com.suresursus.fore.mapper.OrderMapper;
import com.suresursus.fore.pojo.Item;
import com.suresursus.fore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper = null;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> getOrder(int ostate, int uno) {
        return orderMapper.getOrder(ostate, uno);
    }
}
