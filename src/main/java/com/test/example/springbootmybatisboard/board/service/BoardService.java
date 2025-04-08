package com.test.example.springbootmybatisboard.board.service;

import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import com.test.example.springbootmybatisboard.board.dto.BoardResultDto;

public interface BoardService {
    BoardResultDto listBoard(BoardParamDto boardParamDto);
    BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto);
}
