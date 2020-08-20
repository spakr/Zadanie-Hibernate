package com.roman.server.operations;

import com.roman.server.entity.DayMenu;
import com.roman.server.entity.MainMeal;
import com.roman.server.entity.Soup;
import com.roman.server.util.DayEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddMenuThree {

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

            DayMenu menu1 = new DayMenu("menu3", DayEnum.Tuesday,8.5f,400,true,false);
            menu1.setMainMeal(new MainMeal("Pizza"));
            Soup soupGarlic = new Soup("Chicken soup");
            Soup soupTomato = new Soup("Tomato soup");
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
