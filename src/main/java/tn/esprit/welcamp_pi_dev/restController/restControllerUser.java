package tn.esprit.welcamp.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.welcamp.entities.User;
import tn.esprit.welcamp.services.IServicesUser;

import javax.websocket.server.PathParam;

@RestController
public class restControllerUser {

    @Autowired
    IServicesUser iS;

    @PostMapping("addUser")
    User addUser(@RequestBody User u) {
        return iS.addUser(u);
    }

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


}
