package com.micloud.actuator.component.health;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/21 9:24
 */
@Component
public class HealthEntity {

    private HealthEntity(){
    }

    private static class InnerClass{
        private static HealthEntity healthEntity = new HealthEntity();
    }


    @Getter
    @Setter
    private String  defaultKettleUrl;

    @Getter
    @Setter
    private String  defaultUrl;

    @Getter
    @Setter
    private String  defaultIp;
    @Getter
    @Setter
    private String  uriPrefix;



    public static HealthEntity getInstance() {
        return InnerClass.healthEntity;
    }

}
