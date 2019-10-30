package com.suresursus.fore.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.suresursus.fore.pojo.Item;
import com.suresursus.fore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("itemController")
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService = null;

    @ResponseBody
    @RequestMapping(value = "/getCategory", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String getCategory(@RequestParam("cno") int cno){
        List<Item> list = itemService.getCategory(cno);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getRecommend", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String getRecommend(@RequestParam("num") int num){
        List<Item> list = itemService.getRecommend(num);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getShoppingcart", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String getShoppingcart(@RequestParam("uno") int uno){
        List<Item> list = itemService.getShoppingcart(uno);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getItem", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String getItem(@RequestParam("ino") int ino){
        List<Item> list = itemService.getItem(ino);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/search", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String search(@RequestParam("iname") String iname){
        List<Item> list = itemService.search(iname);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
