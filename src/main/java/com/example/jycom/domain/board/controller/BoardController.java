package com.example.jycom.domain.board.controller;

import com.example.jycom.domain.board.domain.Board;
import com.example.jycom.domain.board.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jycom/board")
public class BoardController {

    private final BoardService boardService;

    private static final Logger logger = LogManager.getLogger(BoardController.class);

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String boardAll(Model model) {
        logger.info("board 진입");

        boardService.boardAll(model);

        return "content/board";
    }

    @GetMapping("/write")
    public String write(Model model){
        logger.info("board write 진입");

        model.addAttribute("board", new Board());

        return "content/addForm";
    }

    @PostMapping("/write")
    public String write(Model model, @ModelAttribute("board") Board board) {

        logger.info("board write 작성");

        boardService.write(board);
        boardService.boardAll(model);

        return "content/board";
    }

    @DeleteMapping("/remove")
    public String remove(Model model, @ModelAttribute("board") Board board) {

        boardService.remove(board);
        boardService.boardAll(model);

        return "content/board";
    }
}
