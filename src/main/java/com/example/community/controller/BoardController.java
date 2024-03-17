package com.example.community.controller;


import com.example.community.entity.Board;
import com.example.community.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web")
@Log4j2
public class BoardController {

    //리스트,뷰,레지스터,모디파이,딜리트

    @Autowired
    private BoardRepository boardRepository;



    @GetMapping("/boardlist")
    public void listGet(Model model){
        List<Board> boards = boardRepository.boardSelectAll();
        model.addAttribute("boards", boards);

    }

    @PostMapping("/boardlist")
    public void listPost(Model model){

    }




    @GetMapping("/boardregister")
    public void registerGet(){

    }

    @PostMapping("/boardregister")
    public String registerPost(String title,String content,String writer){

        Board board = Board.builder().title(title).content(content).writer(writer).build();
        boardRepository.save(board);

        return "redirect:/web/boardlist";

    }




    @GetMapping("/boardview")
    public void viewGet(Model model,Long bno){

        Optional<Board> board = boardRepository.boardSelectOne(bno);
        Board board1 = board.orElseThrow();
        model.addAttribute("board",board1);

    }

    @PostMapping("/boardview")
    public void viewPost(Model model){

    }




    @GetMapping("/boardmodify")
    public void modifyGet(Model model,Long bno){

        Optional<Board> board = boardRepository.boardSelectOne(bno);
        Board board1 = board.orElseThrow();
        model.addAttribute("board",board1);
    }

    @PostMapping("/boardmodify")
    public String modifyPost(Long bno,String title,String content, String writer){

        boardRepository.boardUpdate(bno, title, content, writer);

        return "redirect:/web/boardlist";

    }





    @GetMapping("/boarddelete")
    public String deleteGet(Model model,Long bno){

        boardRepository.boardDelete(bno);

        return "redirect:web/boardmodify";
    }

    @PostMapping("/boarddelete")
    public void deletePost(Model model){

    }
}
