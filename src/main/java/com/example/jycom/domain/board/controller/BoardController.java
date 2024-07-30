package com.example.jycom.domain.board.controller;

import com.example.jycom.domain.board.domain.Board;
import com.example.jycom.domain.board.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String boardAll(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        logger.info("board 진입");

        boardService.boardAll(model, pageable);

        return "content/board";
    }

    @GetMapping("/write")
    public String write(Model model){
        logger.info("board write 진입");

        model.addAttribute("board", new Board());

        return "content/addForm";
    }

    @PostMapping("/write")
    public String write(Model model, @ModelAttribute("board") Board board, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        logger.info("board write 작성");

        boardService.write(board);
        boardService.boardAll(model, pageable);

        return "content/board";
    }

    @GetMapping("/read")
    public String read(@RequestParam("id") String id, Model model) {

        logger.info("id chk : " + id);
        model.addAttribute("board", boardService.read(id));

        return "content/readForm";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") String id, Model model) {

        logger.info("id chk : " + id);
        model.addAttribute("board", boardService.read(id));

        return "content/modifyForm";
    }

    @PostMapping("modify")
    public String modify(Model model, @ModelAttribute("board") Board board) {

        model.addAttribute("board", boardService.modify(board));

        return "content/readForm";
    }

    @GetMapping ("/remove")
    public String remove(@RequestParam("id") String id, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        boardService.remove(id);
        boardService.boardAll(model, pageable);

        return "content/board";
    }
}
