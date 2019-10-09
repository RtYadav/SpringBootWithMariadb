package com.idemia.SpringbootWithMariadbAss.controller;

import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import com.idemia.SpringbootWithMariadbAss.repo.SaleItemRepo;
import com.idemia.SpringbootWithMariadbAss.service.Calculation;
import com.idemia.SpringbootWithMariadbAss.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/item")
public class SaleItemController {
    @Autowired
    SaleItemRepo saleItemRepo;
    @Autowired
    SaleItemService saleItemService;
    @Autowired
    Calculation calculation;

    private static final String SAVEITEM = "/save";
    private static final String GETITEM = "/get";
    private static final String DELETEITEM = "/delete/{id}";
    private static final String UPDATEITEM = "/update";
    private static final String PATCHITEM = "/patch";

    @PostMapping(SAVEITEM)
    public String saveItem(@RequestBody SaleItem saleItem) {
        saleItemRepo.save(saleItem);

        return "successfully added sale item ";
    }

    @GetMapping(GETITEM)
    public ResponseEntity<List<SaleItem>> getItems() {
        //calculation.discountAmountInInr();
        // return calculation.payableAmountAfterDiscountInInr();
        ResponseEntity<List<SaleItem>> responseEntity;
        List<SaleItem> saleItemList = saleItemService.getItems();
        return new ResponseEntity<List<SaleItem>>(saleItemList, null, HttpStatus.OK);

    }

    @DeleteMapping(DELETEITEM)
    public ResponseEntity<SaleItem> deleteItem(@PathVariable(value = "id") Long itemId) {
        ResponseEntity<SaleItem> responseEntity;
        Boolean result = saleItemService.deleteById(itemId);
        if (result) {
            responseEntity = new ResponseEntity<SaleItem>(null, null, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<SaleItem>(null, null, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping(UPDATEITEM)
    public String updateItem(@RequestParam(name = "id") Long id, @RequestBody SaleItem saleItem) {

        saleItemService.updateItem(id, saleItem);
        return "updated successfully";
    }

    @PatchMapping(PATCHITEM)
    public String patchName(@RequestParam(name = "itemName") String itemName, @RequestParam(name = "id") Long id) {
        saleItemService.patchName(itemName, id);
        return "Name updated successfully";
    }
}

