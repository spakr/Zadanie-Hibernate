package com.roman.server.operations;

import com.roman.server.entity.DayMenu;
import com.roman.server.entity.MainMeal;
import com.roman.server.entity.Soup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMenu {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DayMenu.class)
                .addAnnotatedClass(MainMeal.class)
                .addAnnotatedClass(Soup.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 7 ;

            DayMenu dayMenu = session.get(DayMenu.class,id);

            session.delete(dayMenu);

            session.getTransaction().commit();

        }finally {
            factory.close();
            session.close();

        }
    }
}
