package com.roman.server.operations;

import com.roman.server.entity.DayMenu;
import com.roman.server.entity.MainMeal;
import com.roman.server.entity.Soup;
import com.roman.server.util.DayEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddMenuTwo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(DayMenu.class)
                        .addAnnotatedClass(MainMeal.class)
                        .addAnnotatedClass(Soup.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            DayMenu menu1 = new DayMenu("menu2", DayEnum.Wednesday,4.5f,300,false,false);
            menu1.setMainMeal(new MainMeal("Steak with fries"));
            Soup soupGarlic = new Soup("Vegetable soup");
            Soup soupTomato = new Soup("Romans soup");
            menu1.addSoup(soupGarlic);
            menu1.addSoup(soupTomato);
            session.save(menu1.getMainMeal());
            session.save(menu1);
            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
    }
}
