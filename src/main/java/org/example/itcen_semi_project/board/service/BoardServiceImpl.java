package org.example.itcen_semi_project.board.service;

import lombok.RequiredArgsConstructor;
import org.example.itcen_semi_project.board.domain.Board;
import org.example.itcen_semi_project.board.domain.dto.ListBoardDTO;
import org.example.itcen_semi_project.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardMapper;

    @Override
    public List<ListBoardDTO> readBoard(int cpg) {
        return boardMapper.selectBoard(cpg);
    }

    @Override
    public Board readOneBoard(int bno) {
        return boardMapper.selectOneBoard(bno);
    }

}

