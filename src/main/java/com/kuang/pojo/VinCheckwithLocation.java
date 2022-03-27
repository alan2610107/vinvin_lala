package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinCheckwithLocation extends VinCheck{
    private String location;

    public VinCheckwithLocation(VinCheck vinCheck, String location) {
        super(vinCheck.getLogid(),vinCheck.getId(),vinCheck.getItemName(),vinCheck.getBrand(),vinCheck.getCheckitemCount(),vinCheck.getRealitemCount(), vinCheck.getDifference(), vinCheck.getIfmatch(), vinCheck.getTime(), vinCheck.getCategory());
        this.location = location;
    }
}
