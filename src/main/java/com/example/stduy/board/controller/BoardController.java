package com.example.stduy.board.controller;

import com.example.stduy.board.dto.BoardDTO;
import com.example.stduy.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute(boardService.selectList());
        return "board/list";
    }

    //글 조회
    @GetMapping(value = {"/{boardNo}}", "/{boardNo}/modify"})
    public String read(@PathVariable Long boardNo, Model model) {
        BoardDTO boardDTO = boardService.select(boardNo);
        model.addAttribute("board", boardDTO);
        return "board/{boardNo}";
    }


    // 글 등록
    @PostMapping("/register")
    public String register(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("boardNo", boardService.insert(boardDTO));
        redirectAttributes.addAttribute("status", true);
        return "redirect:/board/{boardNo}";
    }

    //글 수정
    @PostMapping("/{boardNo}/modify")
    public String modify(@PathVariable Long boardNo, @ModelAttribute BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "redirect:/board/{boardNo}";
    }

    //글 삭제
    @PostMapping("/{boardNo}/remove")
    public String remove(@PathVariable Long boardNo) {
        boardService.delete(boardNo);
        return "redirect:/board/list";
    }
}
