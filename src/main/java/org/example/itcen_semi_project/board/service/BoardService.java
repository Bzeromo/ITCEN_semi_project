package org.example.itcen_semi_project.board.service;

import org.example.itcen_semi_project.board.domain.Board;
import org.example.itcen_semi_project.board.domain.dto.ListBoardDTO;

import java.util.List;

public interface BoardService {

    List<ListBoardDTO> readBoard(int cpg);

    Board readOneBoard(int bno);

}
