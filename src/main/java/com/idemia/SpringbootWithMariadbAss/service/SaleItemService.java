package com.idemia.SpringbootWithMariadbAss.service;

import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface SaleItemService {
    public List<SaleItem> getItems();

    public void updateItem(Long id, SaleItem saleItem);

    public void patchName(String itemName, Long id);

    boolean deleteById(Long itemId);
}
