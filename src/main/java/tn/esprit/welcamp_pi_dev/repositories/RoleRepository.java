package tn.esprit.welcamp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.welcamp.entities.Role;

import java.util.List;

@Repository
public interface RoleRepository  extends CrudRepository<Role,Integer> {
@Query(value="SELECT * FROM role r WHERE r.user_id_membre = ?1 ", nativeQuery = true)
List<Role> getRoleByIdMembre( int idMembre);
}
