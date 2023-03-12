package tn.esprit.welcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date Date;
    private String State;

    @ManyToOne
    User user;

    @ManyToOne
    CampSite campSite;

    @ManyToOne
    private Delivery delivery;
}
