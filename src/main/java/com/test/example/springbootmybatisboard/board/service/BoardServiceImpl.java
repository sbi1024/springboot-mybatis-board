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

    @Override
    public BoardResultDto detatailBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        // 예외 처리
        try {
            BoardDto boardDto = boardDao.detailBoard(boardParamDto);
            if (boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
                boardDto.setSameUser(true);
            } else {
                boardDto.setSameUser(false);
            }
            boardResultDto.setDto(boardDto);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto insertBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            int ret = boardDao.insertBoard(boardDto);
            if (ret == 1) {
                boardResultDto.setResult("success");
            } else {
                boardResultDto.setResult("fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto updateBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            int ret = boardDao.updateBoard(boardDto);
            if (ret == 1) {
                boardResultDto.setResult("success");
            } else {
                boardResultDto.setResult("fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto deleteBoard(int boardId) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            int ret = boardDao.deleteBoard(boardId);
            if (ret == 1) {
                boardResultDto.setResult("success");
            } else {
                boardResultDto.setResult("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }
        return boardResultDto;
    }
}
