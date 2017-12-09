package com.pial.ramizvai.pojoClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pial on 12/10/17.
 */

public class PhotoPojo {
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
