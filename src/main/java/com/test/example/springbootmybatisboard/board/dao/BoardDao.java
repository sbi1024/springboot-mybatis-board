package com.test.example.springbootmybatisboard.board.dao;

import com.test.example.springbootmybatisboard.board.dto.BoardDto;
import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    List<BoardDto> listBoard(BoardParamDto boardParamDto);

    int listBoardTotalCount();

    List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto);

    int listBoardTotalCountSearchWord(BoardParamDto boardParamDto);
}
