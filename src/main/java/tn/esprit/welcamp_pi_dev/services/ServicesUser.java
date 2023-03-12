package tn.esprit.welcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.welcamp.entities.AuthenticationProvider;
import tn.esprit.welcamp.entities.Role;
import tn.esprit.welcamp.entities.User;
import tn.esprit.welcamp.repositories.ClaimRepository;
import tn.esprit.welcamp.repositories.RoleRepository;
import tn.esprit.welcamp.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesUser implements IServicesUser {
    @Autowired
    ClaimRepository cr;
    @Autowired
    UserRepository ur;
    @Autowired
    RoleRepository rr;
    @Override
    public User addUser(User u) {
        return ur.save(u);
    }

    @Override
    public void  UpdateUSer(User u) {
        //u.setIdMembre(idMember);
         ur.save(u);
    }

    @Override
    public void deleteUser(int idMembre) {
        ur.deleteById(idMembre);
    }

    @Override
    public User Search(int idMembre) {
        User user = ur.findById(idMembre).get();

        return user;
    }
    @Override
    public List<Role> getRoleById(int idMembre) {
        //  rr.getRoleByIdMembre(idMembre);
        return rr.getRoleByIdMembre(idMembre);
    }




    public void processOAuthPostLogin(String username) {
        User existUser = this.ur.getUserByUsername(username);
        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setAutheProvider(AuthenticationProvider.GOOGLE);
            newUser.setEnable(true);
            this.ur.save(newUser);
            System.out.println("Created new user: " + username);
        }

    }




    /*
    @Override
    public org.springframework.security.core.userdetails.User getUserByUsername(String username) throws UsernameNotFoundException {
        User user = ur.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        List<Role> roles = rr.getRoleByIdMembre(user.getIdMembre());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(roles)
        );
    }



    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());
    }

     */
}
