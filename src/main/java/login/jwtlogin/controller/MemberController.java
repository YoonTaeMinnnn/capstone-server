package login.jwtlogin.controller;

import login.jwtlogin.auth.PrincipalDetails;
import login.jwtlogin.controller.exception.ExceptionMessages;
import login.jwtlogin.controller.memberDto.MyPageDto;
import login.jwtlogin.domain.Member;
import login.jwtlogin.repository.MemberRepository;
import login.jwtlogin.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity myPage(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        Member member = principalDetails.getMember();
        Member findMember = memberRepository.findById(member.getId()).orElseThrow(
                () -> new EntityNotFoundException(ExceptionMessages.NOT_FOUND_MEMBER)
        );
        MyPageDto my = memberService.detail(findMember);
        return ResponseEntity.ok(my);
    }
}
