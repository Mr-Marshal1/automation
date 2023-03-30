package itstep.task6.task7;
import itstep.task6.entity.Device;
import itstep.task6.entity.Shade;
import itstep.task6.entity.SocialMedia;
import org.hibernate.Session;
import org.hibernate.Session;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import itstep.task6.*;
import itstep.task6.entity.Color;
import static itstep.task6.HibernateUtil.getSessionFactory;

public class HibernateMain7 {

  // Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
   // Test it by CRUD.

    public static void main(String[] args) {
        Color color = new Color(Arrays.asList("red", "green", "blue"), true);
        Map<String, Integer> rgb = new HashMap<String, Integer>();
        rgb.put("r", 255);
        rgb.put("g", 0);
        rgb.put("b", 0);
        color.setRgb(rgb);


        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // OneToOne
        color.setShade(new Shade("yellowish"));
        Long id = (Long) session.save(color);
        System.out.println("OneToOne" + session.get(Color.class, id));

        //OneToMany
        color.setDevices(new HashSet<>(Arrays.asList(new Device("iMac"), new Device("iPod"))));
        session.saveOrUpdate(color);
        color.getDevices().forEach(session::save);
        System.out.println("OneToMany" + session.get(Color.class, id));

        //ManyToMany
        Color color2 = new Color(Arrays.asList("yellow", "white", "purple"), false);
        SocialMedia facebook = new SocialMedia("blue");
        SocialMedia instagram = new SocialMedia("blue-blue");
        Long id2 = (Long) session.save(color2);

        session.save(facebook);
        session.save(instagram);

        color.setSocialMedia(Arrays.asList(facebook));
        color2.setSocialMedia(Arrays.asList(facebook, instagram));

        session.saveOrUpdate(color);
        session.save(color2);

        System.out.println("ManyToMany" + session.get(Color.class, id));
        System.out.println("ManyToMany" + session.get(Color.class, id2));

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

}
