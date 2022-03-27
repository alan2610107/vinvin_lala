package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
// implements Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinItemSimple{
    private String id;
    private int itemCount;
    private String category;

}
