package tn.esprit.welcamp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.welcamp.entities.Claim;
import tn.esprit.welcamp.entities.Reservation;

import java.util.List;
@Repository
public interface ClaimRepository extends CrudRepository <Claim,Integer>{

    /*@Query(value="SELECT COUNT(*) FROM reservation r WHERE r.user_id_membre = ?1 AND r.camp_site_id_campsite = ?2", nativeQuery = true)
    int reservationNumbre(int idMembre, int idCampsite);*/

}
