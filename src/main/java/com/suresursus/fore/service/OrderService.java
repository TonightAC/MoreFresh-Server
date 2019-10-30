package com.suresursus.fore.service;

import com.suresursus.fore.pojo.Item;

import java.util.List;

public interface OrderService {
    List<Item> getOrder(int ostate, int uno);
}
