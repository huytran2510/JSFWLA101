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
public class TurbineUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String confirmPassword;

    @Column
    private String email;

    @Column
    private String inPhone;

    @Column
    private String outPhone;

    @Column
    private String cellularPhone;

    @Column
    private String cellularEmail;

    @Lob
    private byte[] file;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId",referencedColumnName = "id")
    private EipCompany eipCompany ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "positionId", referencedColumnName = "id")
    private EipPosition eipPosition;

}
