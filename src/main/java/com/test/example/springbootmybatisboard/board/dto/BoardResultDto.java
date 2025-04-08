package com.test.example.springbootmybatisboard.board.dto;

import java.util.List;

public class BoardResultDto {
    private String result;
    private List<BoardDto> list;
    private BoardDto dot;
    private int count;



    @Override
    public String toString() {
        return "BoardResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dot=" + dot +
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

    public BoardDto getDot() {
        return dot;
    }

    public void setDot(BoardDto dot) {
        this.dot = dot;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
