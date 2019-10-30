package com.suresursus.fore.mapper;

import com.suresursus.fore.pojo.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
    List<Item> getCategory(Integer cno);
    List<Item> getAllItem();
    List<Item> getShoppingcart(Integer uno);
    List<Item> getItem(Integer ino);
}
