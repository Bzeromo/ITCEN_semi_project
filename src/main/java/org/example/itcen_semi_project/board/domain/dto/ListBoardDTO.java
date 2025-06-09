package org.example.itcen_semi_project.board.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListBoardDTO {

    private String bno;
    private String title;
    private String userid;
    private String regdate;
    private String thumbs;
    private String views;

}
