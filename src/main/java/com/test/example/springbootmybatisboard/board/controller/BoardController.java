package com.test.example.springbootmybatisboard.board.controller;

import com.test.example.springbootmybatisboard.board.dto.BoardDto;
import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import com.test.example.springbootmybatisboard.board.dto.BoardResultDto;
import com.test.example.springbootmybatisboard.board.service.BoardService;
import com.test.example.springbootmybatisboard.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail/{boardId}")
    @ResponseBody
    public BoardResultDto detailBoard(@PathVariable Integer boardId, HttpSession session) {
        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setBoardId(boardId);

        int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq();
        boardParamDto.setUserSeq(userSeq);

        return boardService.detailBoard(boardParamDto);
    }

    @PostMapping("/insert")
    @ResponseBody
    public BoardResultDto insertBoard(BoardDto boardDto, HttpSession session) {
        int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq();
        boardDto.setUserSeq(userSeq);
        return boardService.insertBoard(boardDto);
    }

    @PostMapping("/update")
    @ResponseBody
    public BoardResultDto insertBoard(BoardDto boardDto) {
        return boardService.updateBoard(boardDto);
    }

    @GetMapping("/delete/{boardId}")
    @ResponseBody
    public BoardResultDto deleteBoard(@PathVariable("boardId") int boardId) {
        return boardService.deleteBoard(boardId);
    }
}
