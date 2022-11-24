package com.kumoh.cosmoa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceTableResponseDTO {
		private int id;
	    private String name;
	    private int like;
	    private String nickname;
	    private int replyCount;
}
