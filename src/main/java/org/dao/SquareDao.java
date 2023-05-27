package org.dao;

import org.domain.Square;
import org.hibernate.query.Query;

import java.util.List;

public class SquareDao extends BaseDaoImpl<Square, Integer> {
    public SquareDao() {
        super(Square.class);
    }

    public List<Square> getAllByGroup(String groupName) {
        Query q = getSession().createQuery("FROM Student WHERE Student.grp = \"" + groupName + "\"");
        return q.list();
    }
}
