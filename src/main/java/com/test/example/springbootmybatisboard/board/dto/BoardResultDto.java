package com.test.example.springbootmybatisboard.board.dto;

import java.util.List;

public class BoardResultDto {
    private String result;
    private List<BoardDto> list;
    private BoardDto dto;
    private int count;

    @Override
    public String toString() {
        return "BoardResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dto=" + dto +
                ", count=" + count +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<BoardDto> getList() {
        return list;
    }

    public void setList(List<BoardDto> list) {
        this.list = list;
    }

    public BoardDto getDto() {
        return dto;
    }

    public void setDto(BoardDto dto) {
        this.dto = dto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
