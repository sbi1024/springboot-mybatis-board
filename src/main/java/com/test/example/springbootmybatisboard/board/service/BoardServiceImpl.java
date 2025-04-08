package com.test.example.springbootmybatisboard.board.service;

import com.test.example.springbootmybatisboard.board.dao.BoardDao;
import com.test.example.springbootmybatisboard.board.dto.BoardDto;
import com.test.example.springbootmybatisboard.board.dto.BoardParamDto;
import com.test.example.springbootmybatisboard.board.dto.BoardResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        // 예외 처리
        try {
            List<BoardDto> list = boardDao.listBoard(boardParamDto);
            int count = boardDao.listBoardTotalCount();
            boardResultDto.setCount(count);
            boardResultDto.setList(list);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        // 예외 처리
        try {
            List<BoardDto> list = boardDao.listBoardSearchWord(boardParamDto);
            System.out.println(list);
            int count = boardDao.listBoardTotalCountSearchWord(boardParamDto);
            System.out.println(count);
            boardResultDto.setCount(count);
            boardResultDto.setList(list);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        System.out.println(boardResultDto);

        return boardResultDto;
    }
}
