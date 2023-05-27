package org.dao;

import org.domain.Picture;

public class PictureDao extends BaseDaoImpl<Picture, Integer> {
    public PictureDao() {
        super(Picture.class);
    }
}
