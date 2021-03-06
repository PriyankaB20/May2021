package org.order.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.order.core.model.Item;
import org.order.core.service.ItemService;
import org.order.web.model.request.ItemsRequest;
import org.order.web.model.response.ItemsInCartResponse;
import org.order.web.model.response.ItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ItemsResponse getItems() {

        log.info("ItemController get items");

        List<Item> items = itemService.getItems();
        ItemsResponse itemsResponse = new ItemsResponse();
        itemsResponse.setItems(items);

        log.info("ItemController get items response <<<< with ItemsResponse={}", itemsResponse);

        return itemsResponse;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ItemsResponse addItem(@RequestBody ItemsRequest itemRequest) {

        log.info("ItemController add Item");

        List<Item> items = itemService.addItems(itemRequest.getItems());

        ItemsResponse itemsResponse = new ItemsResponse();
        itemsResponse.setItems(items);

        log.info("ItemController add Item response <<<< with ItemsResponse={}", itemsResponse);

        return itemsResponse;
    }

}
