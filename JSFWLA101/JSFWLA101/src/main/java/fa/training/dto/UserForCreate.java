package fa.training.dto;


import fa.training.entity.EipCompany;
import fa.training.entity.EipPosition;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserForCreate {
    private String username;

    private String password;


    private String firstname;

    private String lastname;


    private String confirmPassword;


    private String email;


    private String inPhone;


    private String outPhone;


    private String cellularPhone;


    private String cellularEmail;



    private String postName;

    private EipPosition eipPosition;

    private EipCompany eipCompany ;

    private byte[] file ;


}
