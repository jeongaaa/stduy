package com.example.stduy.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDTO {

    private Long boardNo;
    private String title;
    private String writer;
    private String content;
}
