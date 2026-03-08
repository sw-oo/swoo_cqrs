package org.example.board_command.api;

import lombok.RequiredArgsConstructor;
import org.example.board_command.api.model.Board;
import org.example.board_command.api.model.BoardDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.RegRes register(Long userIdx, String userName, BoardDto.RegReq dto) {
        Board board = boardRepository.save(dto.toEntity(userIdx, userName));
        return BoardDto.RegRes.from(board);
    }

    public BoardDto.RegRes update(Long idx, BoardDto.RegReq dto) {
        Board board = boardRepository.findById(idx).orElseThrow();
        board.update(dto);

        boardRepository.save(board);
        return BoardDto.RegRes.from(board);
    }

    public void delete(Long idx) {
        boardRepository.deleteById(idx);
    }
}
