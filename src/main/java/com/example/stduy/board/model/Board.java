package com.example.stduy.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private Long boardNo;
    private String title;
    private String writer;
    private String content;

}
