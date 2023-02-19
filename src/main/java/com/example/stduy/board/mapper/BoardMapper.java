package com.example.stduy.board.mapper;

import com.example.stduy.board.dto.BoardDTO;
import com.example.stduy.board.model.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> selectList();

    List<Board> selectMyList();

    void delete(Long boardNo);

    Board select(Long boardNo);

    Long insert(BoardDTO boardDTO);

    void update(Board board);
}
