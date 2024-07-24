package com.example.jycom.domain.board.service;

import com.example.jycom.domain.board.dao.BoardDao;
import com.example.jycom.domain.board.domain.Board;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private static final Logger logger = LogManager.getLogger(BoardService.class);

    private final BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void BoardRetv(Model model){

        Map<String, Object> itemMap = new HashMap<String, Object>();

        List<Board> boardList = new ArrayList<Board>();

        Board board1 = new Board();
        board1.setIndex("1");
        board1.setSubject("first Write");
        board1.setAuthor("first");
        board1.setCreatedDt(LocalDateTime.now());

        boardList.add(board1);

        logger.info("board1 index : " + board1.getIndex());

        itemMap.put("boardList", boardList);

        model.addAttribute("itemMap", itemMap);
    }

    public void write(Board board) {

        boardDao.save(board);

    }
}
