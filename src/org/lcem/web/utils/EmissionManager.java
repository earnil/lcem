package org.lcem.web.utils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.lcem.web.shared.model.Emission;
import org.lcem.web.shared.model.Film;

public class EmissionManager {

    public static void main(String[] args) throws SQLException {
        	
        EmissionManager mgr = new EmissionManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEmission("My Emission", new Date());
        }
        else if (args[0].equals("list")) {
            List<Emission> emissions = mgr.listEvents();
            for (int i = 0; i < emissions.size(); i++) {
            	Emission theEmission = emissions.get(i);
                System.out.println(
                        "Emission: " + theEmission.getName() + " Time: " + theEmission.getDate()
                );
            }
        } else if (args[0].equals("addfimtoemission")) {
            Long emissionId = mgr.createAndStoreEmission("azeaze", new Date());
            Long filmId = mgr.createAndStoreFilm("qsdqsd");
            mgr.addFilmToEmission(filmId, emissionId);
            System.out.println("Added film " + filmId + " to emission " + emissionId);
        }

        HibernateUtil.getSessionFactory().close();
    }

    private Long createAndStoreEmission(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Emission theEmission = new Emission();
        theEmission.setName(title);
        theEmission.setDate(theDate);
        session.save(theEmission);

        session.getTransaction().commit();
        return theEmission.getId();
        
    }

    private Long createAndStoreFilm(String title) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Film theEmission = new Film();
        theEmission.setName(title);
        session.save(theEmission);

        session.getTransaction().commit();
        return theEmission.getId();
        
    }
    
    private List<Emission> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Emission> result = session.createQuery("from Emission").list();
        session.getTransaction().commit();
        return result;
    }
    
    
    private void addFilmToEmission(Long emissionId, Long filmid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Emission aPerson = (Emission) session
                .createQuery("select e from Emission e left join fetch e.films where e.id = :eid")
                .setParameter("eid", emissionId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached
        Film anEvent = (Film) session.load(Film.class, filmid);

        session.getTransaction().commit();

        // End of first unit of work

        aPerson.addToFilm(anEvent); // aPerson (and its collection) is detached

        // Begin second unit of work

        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        session2.update(aPerson); // Reattachment of aPerson

        session2.getTransaction().commit();
    }
    

}