package com.st.jpastudy;

import com.st.jpastudy.model.Account;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        run1();
    }

    private void run1() throws Exception {
        Account account = Account.builder()
                            .username("Alpha")
                            .password("1111")
                            .build();

        Session session = entityManager.unwrap(Session.class);

//        entityManager.persist(account);
        session.save(account);
    }
}
