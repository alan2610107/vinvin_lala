package com.kuang.service;

import com.kuang.pojo.PurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PurchaseControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    public void insertPurchaseItem(String logID){
        PurchaseItem purchaseItem = new PurchaseItem(logID,"PROCESSING",null,null,null,null,null);
        vinService.insertPurchaseItem(purchaseItem);
    }
}
