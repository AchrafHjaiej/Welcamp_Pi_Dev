package tn.esprit.welcamp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.welcamp.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
  /*  @Query("SELECT u FROM  User u where  UPPER(TRIM(u.Username))=UPPER(TRIM(:username) )  ")
    public User findByUsername(@Param("username") String Username);*/

    @Query("SELECT u FROM User u WHERE u.Username = :username")
    User getUserByUsername(@Param("username") String var1);
}
