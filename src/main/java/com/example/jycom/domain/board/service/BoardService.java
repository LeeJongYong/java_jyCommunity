package com.example.jycom.domain.board.service;

import com.example.jycom.domain.board.dao.BoardDao;
import com.example.jycom.domain.board.domain.Board;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

@Service
public class BoardService {

    private static final Logger logger = LogManager.getLogger(BoardService.class);

    private final BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void boardAll (Model model, Pageable pageable){

        List<Board> boardList = new ArrayList<Board>();

        Page<Board> boards = boardDao.findAll(pageable);

        boardList.addAll(boards.getContent());



        model.addAttribute("boardList", boardList);

    }

    public void write (Board board) {
        boardDao.save(board);
    }


    public void remove (String id) {
        boardDao.deleteById(id);
    }

    public Board read(String id) {
        return boardDao.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Board modify(Board board) {
        boardDao.save(board);
        return boardDao.findById(board.getId()).orElseThrow(NoSuchElementException::new);
    }
}
