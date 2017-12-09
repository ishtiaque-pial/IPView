package com.pial.ramizvai.pojoClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pial on 12/10/17.
 */

public class UrlPojo {
    @SerializedName("urlName")
    @Expose
    private String urlName;

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }
}
