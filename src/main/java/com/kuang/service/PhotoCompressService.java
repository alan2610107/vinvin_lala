package com.kuang.service;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service
public class PhotoCompressService {

    public void doCompressService(long fileSize, String filePath) {
        System.out.println("圖片大小 => "+fileSize);
        double scaleNum = 1;
        if(fileSize < 500000){
            scaleNum = 1;
        } else if(fileSize >= 500000 && fileSize < 1000000){
            scaleNum = 0.9;
        }else if(fileSize >= 1000000 && fileSize < 1500000){
            scaleNum = 0.7;
        }else if(fileSize >= 1500000 && fileSize < 2000000){
            scaleNum = 0.5;
        }else {
            scaleNum = 0.3;
        }
        System.out.println("縮放比例 => "+scaleNum);
        if(scaleNum != 1){
            try {
                Thumbnails.of(new File(filePath)).scale(scaleNum).toFile(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
