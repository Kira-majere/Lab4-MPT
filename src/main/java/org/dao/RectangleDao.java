package org.dao;

import org.domain.Rectangle;

public class RectangleDao extends BaseDaoImpl <Rectangle, Integer> {
    public RectangleDao() {
        super(Rectangle.class);
    }
}
