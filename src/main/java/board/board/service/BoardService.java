package board.board.service;

import board.board.doamin.Board;
import board.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardMapper boardMapper;

    public Board findById(Long boardId){
        return boardMapper.findById(boardId);
    }

    @Transactional
    public Long add(Board board) {
        boardMapper.save(board);
        return board.getId();
    }

    @Transactional
    public Long update(Board board){
        return boardMapper.update(board).getId();
    }

    public void delete(Long boardId) {
        boardMapper.delete(boardId);
    }
}
