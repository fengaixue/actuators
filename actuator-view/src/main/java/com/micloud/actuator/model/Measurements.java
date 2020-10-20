package com.micloud.actuator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/01 12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurements {

   private  String statistic;
   private  Long value;
}
