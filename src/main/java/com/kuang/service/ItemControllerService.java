package com.kuang.service;

import com.kuang.pojo.ItemSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    public void addItemSetByCategory(ItemSet itemSet, String category){
        switch (category){
            case "tool":
                vinService.deleteItemToolSet(itemSet.getItemID());
                vinService.updateItemToolSet(itemSet);
                vinService.addItemToolSet(itemSet);
                break;
            case "smalltool":
                vinService.deleteItemSmallToolSet(itemSet.getItemID());
                vinService.updateItemSmallToolSet(itemSet);
                vinService.addItemSmallToolSet(itemSet);
                break;
            case "food":
                vinService.deleteItemFoodSet(itemSet.getItemID());
                vinService.updateItemFoodSet(itemSet);
                vinService.addItemFoodSet(itemSet);
                break;
            case "commercial":
            case "commercialthing":
                vinService.deleteItemCommercialSet(itemSet.getItemID());
                vinService.updateItemCommercialSet(itemSet);
                vinService.addItemCommercialSet(itemSet);
                break;
            case "other":
                vinService.deleteItemOthersSet(itemSet.getItemID());
                vinService.updateItemOthersSet(itemSet);
                vinService.addItemOthersSet(itemSet);
                break;
        }
    }
}
