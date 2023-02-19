package com.example.stduy.board.service;

import com.example.stduy.board.dto.BoardDTO;
import com.example.stduy.board.mapper.BoardMapper;
import com.example.stduy.board.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public BoardDTO select(Long boardNo) {
        Board board = boardMapper.select(boardNo);
        return entityToDTO(board);
    }

    @Override
    public Long insert(BoardDTO boardDTO) {
        return boardMapper.insert(boardDTO);
    }

    @Override
    public void update(BoardDTO boardDTO) {
        Board board = dtoToEntity(boardDTO);

        boardMapper.update(board);
    }


    @Override
    public void delete(Long boardNo) {
        boardMapper.delete(boardNo);
    }

    @Override
    public List<BoardDTO> selectList() {
        return boardMapper.selectList().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BoardDTO> selectMyList() {
        return boardMapper.selectMyList().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    //Domain  역할
    private Board dtoToEntity(BoardDTO boardDTO) {
        return Board.builder()
                .boardNo(boardDTO.getBoardNo())
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .build();
    }

    private BoardDTO entityToDTO(Board board) {
        return BoardDTO.builder()
                .boardNo(board.getBoardNo())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
    }
}
