package com.idemia.SpringbootWithMariadbAss.service;

import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import com.idemia.SpringbootWithMariadbAss.repo.SaleItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements SaleItemService {
    @Autowired
    SaleItemRepo saleItemRepo;

    @Override
    public List<SaleItem> getItems() {
        List<SaleItem> list = (List<SaleItem>) saleItemRepo.findAll();


        return list;
    }

    @Override
    public void updateItem(Long id, SaleItem saleItem) {

        SaleItem saleItem1 = saleItemRepo.findById(id).get();
        saleItem1.setItemName(saleItem.getItemName());
        saleItem1.setPercentDiscount(saleItem.getPercentDiscount());
        saleItem1.setPrice(saleItem.getPrice());
        saleItemRepo.save(saleItem1);
    }

    @Override
    public void patchName(String itemName, Long id) {
        SaleItem obj1 = saleItemRepo.findById(id).get();
        obj1.setItemName(itemName);
        saleItemRepo.save(obj1);

    }

    @Override
    public boolean deleteById(Long itemId) {
        saleItemRepo.deleteById(itemId);
        return true;
    }


}
