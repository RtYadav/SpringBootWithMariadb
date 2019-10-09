package com.idemia.SpringbootWithMariadbAss.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_saleItem")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId")
    private Long itemId;
    @Column(name = "itemName")
    public String itemName;
    @Column(name = "price")
    private int price;
    @Column(name = "percentDiscount")
    private int percentDiscount;
}
