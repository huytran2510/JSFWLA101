package fa.training.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EipPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String postName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    private EipCompany eipCompany;
}
