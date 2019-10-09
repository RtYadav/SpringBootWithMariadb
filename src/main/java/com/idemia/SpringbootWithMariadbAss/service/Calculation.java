package com.idemia.SpringbootWithMariadbAss.service;

import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import com.idemia.SpringbootWithMariadbAss.repo.SaleItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class Calculation {
    @Autowired
    SaleItemRepo saleItemRepo;

    public List<Integer> discountAmountInInr() {
        List<SaleItem> saleItemList = new ArrayList<>();

        saleItemList = (List<SaleItem>) saleItemRepo.findAll();
        List<Integer> list = saleItemList.stream().map(price -> (price.getPrice() * (price.getPercentDiscount())) / 100).collect(Collectors.toList());
        list.forEach(System.out::println);

        return list;
    }

    public Stream<Integer> payableAmountAfterDiscountInInr() {
        List<SaleItem> saleItemList = new ArrayList<>();
        saleItemList = (List<SaleItem>) saleItemRepo.findAll();
       return saleItemList.stream().map(price -> (price.getPrice() - ((price.getPrice() * (price.getPercentDiscount())) / 100)));
       // list.forEach(System.out::println);

    }
}
