package com.suresursus.fore.service.impl;

import com.suresursus.fore.mapper.ItemMapper;
import com.suresursus.fore.pojo.Item;
import com.suresursus.fore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper = null;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> getCategory(int cno) {
        return itemMapper.getCategory(cno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> getRecommend(int num){
        List<Item> list = new ArrayList<>();
        List<Item> temp = itemMapper.getAllItem();
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while(set.size() != num){
            int n = random.nextInt(temp.size());
            if(set.contains(n)){
                continue;
            }else{
                set.add(n);
                list.add(temp.get(n));
            }
        }
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> getShoppingcart(int uno) {
        return itemMapper.getShoppingcart(uno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> getItem(int ino) {
        return itemMapper.getItem(ino);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<Item> search(String iname) {
        List<Item> list = new ArrayList<>();
        List<Item> temp = itemMapper.getAllItem();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getIname().contains(iname)){
                list.add(temp.get(i));
            }
        }
        return list;
    }
}