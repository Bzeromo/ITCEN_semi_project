package org.example.itcen_semi_project.member.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginDTO {

    private String userid;
    private String passwd;

}
