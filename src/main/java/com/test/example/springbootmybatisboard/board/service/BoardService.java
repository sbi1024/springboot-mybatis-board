package com.test.example.springbootmybatisboard.board.service;

import com.test.example.springbootmybatisboard.board.dto.BoardDto;
import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import com.test.example.springbootmybatisboard.board.dto.BoardResultDto;

public interface BoardService {
    BoardResultDto listBoard(BoardParamDto boardParamDto);
    BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto);

    BoardResultDto detatailBoard(BoardParamDto boardParamDto);
    BoardResultDto insertBoard(BoardDto boardDto);
    BoardResultDto updateBoard(BoardDto boardDto);
    BoardResultDto deleteBoard(int boardId);
}
