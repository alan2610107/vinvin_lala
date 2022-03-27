package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPage {
    private String location;
    private String notReceiveLink;
    private String notConfirmLink;
    private String notDoneLogLink;
    private int notReceiveNum;
    private int notConfirmNum;
    private String realname;
    private int noticeExpiredCount;
    private int notInputDateinExpiredCount;

}