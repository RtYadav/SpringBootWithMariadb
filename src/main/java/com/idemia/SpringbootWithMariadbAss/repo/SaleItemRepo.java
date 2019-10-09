package com.idemia.SpringbootWithMariadbAss.repo;

import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleItemRepo extends CrudRepository<SaleItem, Long> {
   // @Query(value = "select price from tbl_saleItem ")
    //List<SaleItem> select();
}
