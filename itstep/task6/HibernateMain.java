package itstep.task6;

import itstep.task6.entity.Color;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static itstep.task6.HibernateUtil.getSessionFactory;

      //  Install MySQL server
     //   Make at least two tables (Entities from previous task or any additional if need)
      //  Make models for those Entities (from Task_5)
      //  Setup Hibernate for those Entities and local DB
      //  Check basic CRUD (create, read, update, delete the BD records using Hibernate)
       // Generate few rows into all tabled


public class HibernateMain {

    public static void main(String[] args) {
        Color color = new Color(Arrays.asList("red", "green", "blue"),true);
        Map<String,Integer> rgb = new HashMap<String,Integer>();
        rgb.put("r",255);
        rgb.put("g",0);
        rgb.put("b",0);
        color.setRgb(rgb);


        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // CRUD (create, read, update, delete)
        // create
        Long id = (Long) session.save(color);
        System.out.println("id " + id);

        // read
        Color coloread = session.get(Color.class,id);
        System.out.println("coloread " + coloread);

        // update
        Color colorUpdate = coloread;
        colorUpdate.setColors(Arrays.asList("yellow", "blue", "white"));
        session.saveOrUpdate(colorUpdate);
        System.out.println("colorUpdate " + session.get(Color.class, id));

        // delete
        session.delete(color);

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
