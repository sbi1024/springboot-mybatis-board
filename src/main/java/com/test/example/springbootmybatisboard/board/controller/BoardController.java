package com.test.example.springbootmybatisboard.board.controller;

import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import com.test.example.springbootmybatisboard.board.dto.BoardResultDto;
import com.test.example.springbootmybatisboard.board.service.BoardService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    @ResponseBody
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        System.out.println(boardParamDto);
        BoardResultDto boardResultDto = null;
        if (Strings.isEmpty(boardParamDto.getSearchWord())) {
            System.out.println(">>> 1");
            boardResultDto = boardService.listBoard(boardParamDto);
        } else {
            System.out.println(">>> 2");
            boardResultDto = boardService.listBoardSearchWord(boardParamDto);
            System.out.println(boardResultDto);
        }
        return boardResultDto;
    }
}
