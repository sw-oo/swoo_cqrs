package org.example.board_command.api.model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BoardDto {
    @Getter
    public static class RegReq {
        @Schema(description = "제목, 제목은 50글자 까지만 입력 가능ㅎ바니다.", required = true, example = "제목01")
        private String title;
        private String contents;

        public Board toEntity(Long userIdx, String userName) {
            return Board.builder()
                    .title(getTitle())
                    .contents(getContents())
                    .userIdx(userIdx)
                    .userName(userName)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String contents;

        public static RegRes from(Board entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }
}
