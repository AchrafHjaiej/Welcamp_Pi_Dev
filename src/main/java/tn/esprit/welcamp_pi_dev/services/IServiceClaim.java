package tn.esprit.welcamp.services;

import tn.esprit.welcamp.entities.CampSite;
import tn.esprit.welcamp.entities.Claim;

public interface IServiceClaim

{

    public Claim saveClaimByUserId(Claim claim,int idMembre);

    public Claim saveClaimSite(Claim claim, int idMembre, int campSite);
 //   public Claim saveClaimSite1( int idMembre, int campSite);

}
