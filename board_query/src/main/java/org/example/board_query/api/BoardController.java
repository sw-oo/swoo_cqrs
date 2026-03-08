package org.example.board_query.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.board_core.common.model.BaseResponse;
import org.example.board_query.api.model.BoardDto;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Tag(name="게시판 기능")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity list(
            @RequestParam(required = true, defaultValue = "0") int page,
            @RequestParam(required = true, defaultValue = "5") int size) {
        BoardDto.PageRes dto = boardService.list(page, size);
        return ResponseEntity.ok(BaseResponse.success(dto));
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx) {
        BoardDto.ReadRes dto = boardService.read(idx);
        return ResponseEntity.ok(BaseResponse.success(dto));
    }
}
