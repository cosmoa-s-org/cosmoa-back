package com.kumoh.cosmoa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReplyResponseDTO {
    private String nickname;
    private int userId;
    private String comment;
    private String createdDate;
    private String modifiedDate;
    private int courseReplyId;
}
