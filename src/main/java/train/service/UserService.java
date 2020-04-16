package train.service;

import org.springframework.stereotype.Repository;
import train.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    private EntityManager entityManager;

    public int insert(User user) {
        //Inside a transaction

        entityManager.persist(user);
        return user.getUser_id();
    }
}
