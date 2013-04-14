/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import Model.Dica;
import Model.Estado;
import Model.Pergunta;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author José Alexandre
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml)
                // config file.
                AnnotationConfiguration acP = new AnnotationConfiguration().configure("hbnP.cfg.xml");
                acP.addAnnotatedClass(Pergunta.class);
                acP.addAnnotatedClass(Dica.class);
                acP.addAnnotatedClass(Estado.class);
                sessionFactory = acP.configure("hbnP.cfg.xml").buildSessionFactory();
                
                
//                Ativar os schemas
//                SchemaExport se = new SchemaExport(acP);
//                se.create(true, true);
                

            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }

            return sessionFactory;

        } else {
            return sessionFactory;
        }
        
    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }

}
