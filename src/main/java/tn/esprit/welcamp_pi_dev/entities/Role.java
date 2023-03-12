package tn.esprit.welcamp.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Enumerated (EnumType.STRING)
    private TypeRole role;
    String name;
/*
    @OneToMany(mappedBy = "role")
    List<User> UserR;
*/
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }


/*
    public List<User> getUserR() {
        return UserR;
    }

    public void setUserR(List<User> userR) {
        UserR = userR;
    }*/
}
