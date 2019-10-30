package com.suresursus.fore.service;

import com.suresursus.fore.pojo.Item;

import java.util.List;

public interface ItemService {
    List<Item> getCategory(int cno);
    List<Item> getRecommend(int num);
    List<Item> getShoppingcart(int uno);
    List<Item> getItem(int ino);
    List<Item> search(String iname);
}