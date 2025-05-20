package org.example.db14JPAWithRalatedTables;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.db14JPAWithRalatedTables.music.Artist;

public class Main {

    public static void main(String[] args) {

        try  (var sessionFactory =
                Persistence.createEntityManagerFactory(
                        "dev.lpa.music" );
              EntityManager entityManager = sessionFactory.createEntityManager();
        ) {

            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 206);
            System.out.println(artist);
            artist.addAlbum("The Best of Muddy Waters");
            System.out.println(artist);
//            entityManager.remove(artist);
//            entityManager.persist(new Artist("Muddy Water"));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
