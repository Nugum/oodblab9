import entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateDB {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("oodb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Client client = new Client();
        client.setId(15L);
        client.setAddress("Kazan");
        client.setFirstName("Ivan");
        client.setLastName("Ivanov");
        client.setPhoneNumber("88005553535");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
