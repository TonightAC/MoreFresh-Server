package com.suresursus.fore.mapper;

import com.suresursus.fore.pojo.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    List<Item> getOrder(Integer ostate, Integer uno);
}
