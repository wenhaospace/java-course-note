package org.example.db13dataBaseAndJPAInAction;

;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.db13dataBaseAndJPAInAction.music.Artist;

public class Main {

    public static void main(String[] args) {

        try  (var sessionFactory =
                Persistence.createEntityManagerFactory(
                        "dev.lpa.music" );
              EntityManager entityManager = sessionFactory.createEntityManager();
        ) {

            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 205);
            artist.setArtistName("Muddy Waters");
            System.out.println(artist);
//            entityManager.remove(artist);
//            entityManager.persist(new Artist("Muddy Water"));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
