package board.board.mapper;

import board.board.doamin.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    Long save(Board board);

    int boardCount();

    List<Board> findAll();

    Board findById(Long boardId);

    Board update(Board board);

    Board delete(Long boardId);
}