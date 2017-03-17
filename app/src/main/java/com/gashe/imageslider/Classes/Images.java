package com.gashe.imageslider.Classes;

import java.io.Serializable;

/**
 * Created by g5 on 14/3/17.
 */

public class Images {

    private int position;
    private int resId;
    private boolean like;
    private boolean nolike;

    public Images(int position, int resId, boolean like, boolean nolike) {
        this.position = position;
        this.resId = resId;
        this.like = like;
        this.nolike = nolike;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean getNolike() {
        return nolike;
    }

    public void setNolike(boolean nolike) {
        this.nolike = nolike;
    }




}
