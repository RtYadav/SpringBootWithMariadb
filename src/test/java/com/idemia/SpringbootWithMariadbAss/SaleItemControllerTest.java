package com.idemia.SpringbootWithMariadbAss;

import com.idemia.SpringbootWithMariadbAss.controller.SaleItemController;
import com.idemia.SpringbootWithMariadbAss.model.SaleItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SaleItemControllerTest {

    private SaleItemController mockSaleItemController;
    private static SaleItem saleItem;
    private static SaleItem saleItem1;

    @Before
    public void init() {
        mockSaleItemController = mock(SaleItemController.class);
        saleItem = new SaleItem(1L, "maybelline compact", 200, 10);
        saleItem1 = new SaleItem(1L, "ellitin", 250, 5);
        List<SaleItem> saleItemList = new ArrayList<>();
        saleItemList.add(saleItem);
        saleItemList.add(saleItem1);
        when(mockSaleItemController.getItems()).thenReturn(new ResponseEntity<List<SaleItem>>(saleItemList, null, HttpStatus.OK));
        when(mockSaleItemController.updateItem(saleItem.getItemId(), saleItem1)).thenReturn(saleItem.getItemName());
        // when(mockSaleItemController.deleteItem(saleItem.getItemId())).thenReturn("Deleted");
        when(mockSaleItemController.patchName("Lipstik", saleItem1.getItemId())).thenReturn(saleItem1.getItemName());
        when(mockSaleItemController.saveItem(saleItem)).thenReturn(saleItem.getItemName());
    }


    @Test
    public void getItemsTest() {
        ResponseEntity<List<SaleItem>> allItems = mockSaleItemController.getItems();
        assertNotNull("SaleItems are not present in database", allItems);
        assertEquals(200, allItems.getStatusCodeValue());
    }

   /* @Test
    public void deleteItemTest() {
        String status = mockSaleItemController.deleteItem(saleItem.getItemId());
        //ArgumentCaptor<SaleItem> argumentCaptor = ArgumentCaptor.forClass(SaleItem.class);
        // verify(mock())
        assertNotNull(status);
        assertEquals("Deleted", status);
    }*/

    @Test
    public void updateItemTest() {
        String updateStatus = mockSaleItemController.updateItem(saleItem.getItemId(), saleItem1);
        assertNotNull(updateStatus);
        assertEquals(saleItem.getItemName(), updateStatus);

    }

    @Test
    public void patchItemTest() {
        String patchStatus = mockSaleItemController.patchName("Lipstik", saleItem1.getItemId());
        assertNotNull(patchStatus);
        assertEquals(saleItem1.getItemName(), patchStatus);

    }

    @Test
    public void saveItemTest() {
        String saveStatus = mockSaleItemController.saveItem(saleItem);
        assertEquals(saleItem.getItemName(), saveStatus);
        assertThat(saleItem.getItemName(), saleItem.getItemName().equals("maybelline compact"));
    }
}

