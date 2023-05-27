package org;

import org.dao.PictureDao;
import org.dao.SquareDao;
import org.dao.RectangleDao;
import org.domain.Picture;
import org.domain.Square;
import org.domain.Rectangle;
import org.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        SquareDao squareDao = new SquareDao();

        Square square = new Square();
        square.setUgol(4);
        square.setColorline("желтый");
        square.setColorback("малиновый");
        square.setLengt(34);
        square.setWight(34);
        squareDao.save(square);

        PictureDao pictureDao = new PictureDao();

        Picture ist = new Picture();
        ist.setName("Малевич лайт");
        ist.setGraduating(true);
        int savedId = pictureDao.save(ist);
        System.out.println(savedId);

        RectangleDao rectangleDao = new RectangleDao();
        Rectangle rectangle = new Rectangle();
        rectangle.setUgol(4);
        rectangle.setColorline("зеленый");
        rectangle.setWight(23);
        rectangle.setLengt(56);
        rectangle.setPicture(ist);

        rectangleDao.save(rectangle);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setUgol(4);
        rectangle2.setColorline("оранжевый");
        rectangle2.setWight(40);
        rectangle2.setLengt(51);
        rectangle2.setPicture(ist);
        rectangleDao.save(rectangle2);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}