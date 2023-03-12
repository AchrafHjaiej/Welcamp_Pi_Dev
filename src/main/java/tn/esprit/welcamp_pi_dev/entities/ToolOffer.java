package tn.esprit.welcamp.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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
public class ToolOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idToolOffer;
    private int barCode;
    private String toolName;
    private String description;
    private double price;
    private String brand;
    private int weight;
    private String characteristic;
    private int quantity;
    private boolean inStock;
    @Enumerated(EnumType.ORDINAL)
    private TypeCart typeCart;

    @ManyToOne(cascade = CascadeType.ALL)
    private  User user;
    @OneToMany
    private List<CommandLine> commandLines;
    @ManyToOne(cascade = CascadeType.ALL)
    private  CategoryTools categoryTools;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Promotion promotion;
}
