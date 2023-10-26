package fa.training.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EipPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sort;

    private LocalDateTime createDate;

    private LocalDateTime updateTime;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TurbineUser> turbineUserSet;
}
