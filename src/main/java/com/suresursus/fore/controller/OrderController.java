package com.suresursus.fore.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.suresursus.fore.pojo.Item;
import com.suresursus.fore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService = null;

    @ResponseBody
    @RequestMapping(value = "/getOrder", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String getOrder(@RequestParam("ostate") int ostate, @RequestParam("uno") int uno){
        List<Item> list = orderService.getOrder(ostate, uno);
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < list.size(); i++){
            JsonObject jsonObject = new Gson().toJsonTree(list.get(i)).getAsJsonObject();
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
