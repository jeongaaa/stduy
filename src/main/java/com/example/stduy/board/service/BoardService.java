package com.example.stduy.board.service;

import com.example.stduy.board.dto.BoardDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BoardService {

    Long insert(BoardDTO boardDTO);
    void update(BoardDTO boardDTO);
    BoardDTO select(Long boardNo);
    void delete(Long boardNo);
    List<BoardDTO> selectList();

    List<BoardDTO> selectMyList();



}
