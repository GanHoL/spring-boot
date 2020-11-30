package com.wkcto.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:ConfigInfo
 * <p>
 * Package:com.wkcto.springboot.model
 * Description:
 *
 * @Date:2018/8/7 9:35
 * @Author:GanHoL
 */
@Component
@ConfigurationProperties(prefix="info.site")
public class ConfigInfo {

    private String url;

    private String tel;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}