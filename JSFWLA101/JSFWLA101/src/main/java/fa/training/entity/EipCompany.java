package fa.training.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EipCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String companyName ="FPT";

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "eipCompany")
    private Set<TurbineUser> turbineUserSet;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "eipCompany")
    private Set<EipPost> eipPosts;
}
