package tn.esprit.welcamp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.welcamp.entities.Reservation;

import java.util.List;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    List<Reservation> findByUserIdMembreAndCampSiteIdCampsite(int idMembre, int idCampsite);


}
