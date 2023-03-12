package tn.esprit.welcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMembre;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private String Mail;
    private String NumTel;
    private String Adresse;
    @Temporal(TemporalType.DATE)
    private Date Inscription_Date;
    private String Gender;

    private  Boolean Enable;

    @Enumerated(EnumType.STRING)
            @Column(name = "Auth_provider")
    AuthenticationProvider autheProvider;

    public AuthenticationProvider getAutheProvider() {
        return autheProvider;
    }

    public void setAutheProvider(AuthenticationProvider autheProvider) {
        this.autheProvider = autheProvider;
    }


    //-----------------------------------------------achref-----------------------------
//@OneToOne
//Claim claim;
   @JsonIgnore
   @OneToMany(mappedBy = "user")
    List<Claim>claimList;


    @OneToOne
    Interrest interrest;


    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Date getInscription_Date() {
        return Inscription_Date;
    }

    public void setInscription_Date(Date inscription_Date) {
        Inscription_Date = inscription_Date;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }


    public List<ToolOffer> getToolOffers() {
        return toolOffers;
    }

    public void setToolOffers(List<ToolOffer> toolOffers) {
        this.toolOffers = toolOffers;
    }

    public List<Order> getOrdersu() {
        return ordersu;
    }

    public void setOrdersu(List<Order> ordersu) {
        this.ordersu = ordersu;
    }
    //-----------------------------------------------yoyo-----------------------------

    @OneToMany(mappedBy = "user")
    private List<ToolOffer> toolOffers;
    @JsonIgnore
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> ordersu;


//-----------------------------------------------dali-----------------------------

    @JsonIgnore
    @OneToMany (mappedBy = "user")
    List<CampSite>campsites;

    @JsonIgnore
    @OneToMany
    List<Activity> activities;

    @JsonIgnore
    @OneToOne
    Evaluation evaluation;

    @JsonIgnore
    @OneToMany
    List<Favorie> favories;



    @JsonIgnore
    @OneToMany (mappedBy = "user")
    List<Reservation> reservations;

    @JsonIgnore
    @OneToMany
    List<Reservation> reservationsConfirms;

    @JsonIgnore
    @ManyToMany(mappedBy = "userList")
    List<MatchingGroup> matchingGroups;
//-----------------------------------------------ala-----------------------------
//-----------------------------------------------nada-----------------------------

}
