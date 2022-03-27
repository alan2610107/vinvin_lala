package com.kuang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KryOrderDetail {

    @ApiModelProperty(value = "门店", required = true)
    @NotNull
    private Long shopIdenty;
    @ApiModelProperty(value = "订单号", required = true)
    @NotNull
//    @Size(min = 1, max = 20)
    private List<Long> ids;

}
