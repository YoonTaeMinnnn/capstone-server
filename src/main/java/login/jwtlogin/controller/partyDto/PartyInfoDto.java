package login.jwtlogin.controller.partyDto;

import login.jwtlogin.domain.MatchingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PartyInfoDto {

    private Long id;

    private String title;

    private String restaurant;

    private LocalDateTime createdAt;

    private MatchingStatus status;

    private Integer maximumCount;

    private Integer currentCount;
}
