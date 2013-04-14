/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Dica;
import Utils.DataAccessLayerException;
import Utils.HibernateFactoryP;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Andre
 */
public class DicaDao implements Serializable {
    protected Transaction tx;
    protected Session session;

    public DicaDao() {
        HibernateFactoryP.buildIfNeeded();
        
    }

    public void saveOrUpdate(Dica objeto) {
        try {
            startOperation();
            session.saveOrUpdate(objeto);
            session.flush();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactoryP.close(session);
        }
    }

    public void delete(Dica objeto) {
        try {
            startOperation();
            session.delete(objeto);
            session.flush();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactoryP.close(session);
        }
    }

    public Dica find(Long id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(Dica.class, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactoryP.close(session);
        }
        return (Dica) obj;
    }

    public List<Dica> findAll() {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from Dica");
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactoryP.close(session);
        }
        return objects;
    }
    
    public List<Dica> findAllServlet(String nome, List<Long> idDica, List<Integer> idSerie, List<Integer> tipoRede, List<Integer> localizacao, List<Integer> capital) {
        List listinha = null;
        StringBuilder strBuilder = new StringBuilder();
        try {
            startOperation();
            Criteria c = session.createCriteria(Dica.class);
            if (idDica.get(0)>=0)
                c.add(Restrictions.in("regiao", idDica));
            
            if (nome != null && nome != "") {
                    String nomeSplit[] = nome.split(" ");
                    for (String _nome : nomeSplit) {
                        strBuilder.append("%");
                        strBuilder.append(_nome);
                        strBuilder.append("%");
                        _nome = strBuilder.toString();
                        strBuilder.delete(0 , strBuilder.length());
                        c.add(Restrictions.ilike("nome", _nome));
                    }
                }
            strBuilder.delete(0 , strBuilder.length());
            if (idSerie.get(0)>=0)
                c.add(Restrictions.in("serie", idSerie));
            if (tipoRede.get(0)>=0)
                c.add(Restrictions.in("tipoRede", tipoRede));
            if (localizacao.get(0)>=0)
                c.add(Restrictions.in("localizacao", localizacao));
            if (capital.get(0)>=0)
                c.add(Restrictions.in("capital", capital));
            listinha = c.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactoryP.close(session);
        }        
        return listinha;
    }
    
    public void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateFactoryP.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    public void startOperation() throws HibernateException {
        session = HibernateFactoryP.openSession();
        tx = session.beginTransaction();
    }
}
