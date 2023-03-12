package tn.esprit.welcamp.services;

import tn.esprit.welcamp.entities.Role;
import tn.esprit.welcamp.entities.User;

import java.util.List;

public interface IServicesUser {

User addUser (User u);
 void UpdateUSer ( User u);

public void deleteUser (int idMembre);

public User Search (int idMembre);

//public org.springframework.security.core.userdetails.User getUserByUsername (String Username);


public List<Role> getRoleById (int idMembre);

 //private static List<GrantedAuthority> grantedAuthorityList =new ArrayList<>();
}
