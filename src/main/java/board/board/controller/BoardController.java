package board.board.controller;

import board.board.doamin.Board;
import board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/hello")
    public String Hello() {
        return "/board/hello";
    }

    /**
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", boardService.boardCount());
        model.addAttribute("test", boardService.boardList());

        return "/board/hello";
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("boards", boardService.boardList());

        return "/board/boards";
    }
     **/

    @GetMapping("/add")
    public String add() {
        return "/board/addFOrm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String content,
                      RedirectAttributes redirectAttributes) {
        Board newBoard = new Board(title, content);
        Long boardId = boardService.add(newBoard);
        System.out.println("boardId = " + boardId);

        redirectAttributes.addAttribute("boardId", boardId);
        redirectAttributes.addAttribute("status", true);

        return "redirect:/boards/{boardId}";
    }

}
