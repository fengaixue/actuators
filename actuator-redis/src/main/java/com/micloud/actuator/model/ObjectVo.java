package com.micloud.actuator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/11/06 17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectVo {

    public Object data;

    public String url;

    public String reqMethoh;

}
