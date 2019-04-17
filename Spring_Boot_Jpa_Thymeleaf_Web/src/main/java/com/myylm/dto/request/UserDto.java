package com.myylm.dto.request;


import com.myylm.commons.web.request.PageReq;

import javax.validation.constraints.NotNull;

/**
 * @author hmmzhtx
 */
public class UserDto extends PageReq {


    @NotNull
    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
