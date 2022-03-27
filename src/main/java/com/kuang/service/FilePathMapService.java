package com.kuang.service;

import com.kuang.pojo.VinItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;


/**
 * @author  Chi-Lin Wu
 * @apiNote  Get filePathMap by muti-thread
 */
@Service
public class FilePathMapService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    public Future<Map<String, String>> get(List<VinItem> vinItemList){
        return taskExecutor.submit(new Callable<Map<String, String>>() {
            @Override
            public Map<String, String> call() throws Exception {
                Map<String,String> filepathMap = new HashMap<>();
                String filepath;
                for (VinItem vinItem : vinItemList) {
                    filepath = "/no_filepath";
                    String id = vinItem.getId();
                    if(vinService.ifExistFileTypebyID(id) > 0){
                        filepath = vinService.queryFileTypebyid(id).getFilepath();
                    }
                    filepathMap.put(id,filepath);
                }
                return filepathMap;
            }
        });

    }

}
