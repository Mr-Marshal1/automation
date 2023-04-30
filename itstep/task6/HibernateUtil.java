package itstep.task6;

import itstep.task6.entity.Color;
import itstep.task6.entity.Device;
import itstep.task6.entity.Shade;
import itstep.task6.entity.SocialMedia;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {// Create properties for Hibernate configuration
            Properties hibernateProps = new Properties();
            hibernateProps.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            hibernateProps.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=itstep;integratedSecurity=true");
            hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            hibernateProps.put(Environment.SHOW_SQL, "true");
            hibernateProps.put(Environment.HBM2DDL_AUTO, "create");
            hibernateProps.put("hibernate.connection.integratedSecurity", "true");

            // Build the configuration object and register entity classes
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Shade.class);
            configuration.addAnnotatedClass(Color.class);
            configuration.addAnnotatedClass(Device.class);
            configuration.addAnnotatedClass(SocialMedia.class);

            configuration.setProperties(hibernateProps);
            configuration.addAnnotatedClass(Color.class);
            // Build the ServiceRegistry and create the SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }}
    public static SessionFactory getSessionFactory() {
        return sessionFactory; }}