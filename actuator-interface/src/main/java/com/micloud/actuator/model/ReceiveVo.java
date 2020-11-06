package com.micloud.actuator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/11/06 14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveVo {

    private List<MsgReceiveAlarmVo> data;

}
