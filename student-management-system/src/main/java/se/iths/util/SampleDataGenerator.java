package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student user1 = new Student("leo", "ebe", "leo@mail.se", "000");
        Student user2 = new Student("bob", "son", "bob@mail.se", "111");

        Subject item1 = new Subject("Matte");
        Subject item2 = new Subject("Svenska");
        Subject item3 = new Subject("Engelska");

        Teacher teacher1 = new Teacher("pontus","redig","pon@mail.com");

        user1.addSubject(item1);
        user1.addSubject(item2);
        user1.addSubject(item3);
        user2.addSubject(item1);
        user2.addSubject(item3);

        teacher1.addSubject(item1);
        teacher1.addSubject(item2);
        teacher1.addSubject(item3);

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(teacher1);

    }


}
