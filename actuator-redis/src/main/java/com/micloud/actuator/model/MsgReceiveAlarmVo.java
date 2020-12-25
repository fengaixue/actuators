package com.micloud.actuator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/11/06 14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MsgReceiveAlarmVo {

    /** 报警具体事件ID */
    private Integer sysDictriptionId;

    /** 时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date alarmTime;

    /** 报警消息体 */
    private String alarmContent;

}
