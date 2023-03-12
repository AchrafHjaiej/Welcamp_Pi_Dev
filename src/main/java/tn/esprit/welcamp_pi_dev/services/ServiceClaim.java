package tn.esprit.welcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.welcamp.entities.CampSite;
import tn.esprit.welcamp.entities.Claim;
import tn.esprit.welcamp.entities.Reservation;
import tn.esprit.welcamp.entities.User;
import tn.esprit.welcamp.repositories.CampsiteRepository;
import tn.esprit.welcamp.repositories.ClaimRepository;
import tn.esprit.welcamp.repositories.ReservationRepository;
import tn.esprit.welcamp.repositories.UserRepository;

import java.util.List;

@Service
public class ServiceClaim implements IServiceClaim{
    @Autowired
    ClaimRepository cr;
    @Autowired
    UserRepository ur;

    @Autowired
    CampsiteRepository cmr;

    @Autowired
    ReservationRepository resR;



    @Override
    public Claim saveClaimByUserId( Claim claim,int idMembre) {
        Claim cl = cr.save(claim);
        User user=ur.findById(idMembre).get();
        user.getClaimList().add(claim);
        ur.save(user);
        return claim;
    }

    @Override
    public Claim saveClaimSite(Claim claim, int idMembre, int idCampsite) {
        /*boolean count=false;
        List<Reservation> reservations=(List<Reservation>) resR.findAll();
        for (Reservation reser:reservations
             ) {
            if(reser.getCampSite().getIdCampsite()==idCampsite && reser.getUser().getIdMembre()==idMembre) {
                count=true;
            }
        }*/
        var a=resR.findByUserIdMembreAndCampSiteIdCampsite(idMembre,idCampsite);
        if (a.size()>0)
        {
            User user = ur.findById(idMembre).get();
            CampSite campSite = cmr.findById(idCampsite).get();
            claim.setUser(user);
            claim.setCampSite(campSite);
            cr.save(claim);


        }

        return claim;
    }
/*
    @Override
    public Claim saveClaimSite(Claim claim, int idMembre, int idCampsite) {
        if (cr.reservationNumbre(idMembre, idCampsite) > 1) {
            User user = ur.findById(idMembre).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
            CampSite campSite = cmr.findById(idCampsite).orElseThrow(() -> new IllegalArgumentException("Invalid campsite ID"));
            claim.setUser(user);
            claim.setCampSite(campSite);
            //user.setClaimList();
            return cr.save(claim);
        } else {
            throw new IllegalArgumentException("Invalid reservation number");
        }
    }
*/

}
