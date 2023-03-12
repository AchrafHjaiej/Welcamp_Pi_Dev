package tn.esprit.welcamp.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.welcamp.entities.CampSite;
import tn.esprit.welcamp.entities.Claim;
import tn.esprit.welcamp.entities.User;
import tn.esprit.welcamp.services.IServiceClaim;
import tn.esprit.welcamp.services.IServicesUser;
@RestController
public class restControllerClaim {

    @Autowired
    IServiceClaim iSC;

    @PostMapping("addClaim")
    Claim addUser(@RequestBody Claim claim, @RequestParam int idMembre) {
        return iSC.saveClaimByUserId(claim,idMembre);
    }

    @PostMapping("addClaimSite")
    Claim saveClaimSite(@RequestBody Claim claim,@RequestParam int idMembre,@RequestParam int idCampsite) {
        return iSC.saveClaimSite(claim , idMembre, idCampsite);
    }
/*
    @PutMapping("UpdateUser")
    void UpdateUSer(@RequestBody User u) {

        iS.UpdateUSer(u);

    }

    @DeleteMapping("DeleteUser")
    public void deleteUser(@RequestParam int idMembre) {
        iS.deleteUser(idMembre);
    }

    @GetMapping("SearchUser")
    public User Search(int idMembre) {

        return iS.Search(idMembre);
    }

*/

}
