package org.example.itcen_semi_project.member.controller.api;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.itcen_semi_project.common.utils.GoogleRecaptchaService;
import org.example.itcen_semi_project.member.domain.dto.LoginDTO;
import org.example.itcen_semi_project.member.domain.dto.MemberDTO;
import org.example.itcen_semi_project.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberAPIController {

    private final MemberService memberService;
    private final GoogleRecaptchaService googleRecaptchaService;

    @PostMapping("/join")
    public ResponseEntity<?> joinok(MemberDTO member, String recaptchaToken) {
        // 회원 가입 처리시 기타오류 발생에 대한 응답코드 설정
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 회원 정보 : {}", member);
        log.info("submit된 응답 토큰 : {}", recaptchaToken);

        try {
            // 정상 처리시 상태코드 200으로 응답
            if (googleRecaptchaService.verifyRecaptcha(recaptchaToken))
                memberService.newMember(member);
            else
                throw new IllegalStateException("자동가입 방지 오류!!");
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            // 비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
            // 중복 아이디나 중복 이메일 사용시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
            e.printStackTrace();
        }

        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginok(LoginDTO member, HttpSession session, String recaptchaToken) {
        // 로그인 처리시 기타오류 발생에 대한 응답코드 설정
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 로그인 정보 : {}", member);
        log.info("submit된 응답 토큰 : {}", recaptchaToken);

        try {
            if (!googleRecaptchaService.verifyRecaptcha(recaptchaToken))
//                memberService.newMember(member);
                System.out.println("hi" + recaptchaToken);
            else
                throw new IllegalStateException("자동가입 방지 오류!!");

            session.setAttribute("loginUser", session.getAttribute("loginUser"));
            session.setMaxInactiveInterval(600);  // 세션 유지 : 10분

            response = ResponseEntity.ok().body("로그인 성공했습니다!!");
        } catch (IllegalStateException e) {
            // 비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
            // 아이디나 비밀번호 잘못 입력시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
            e.printStackTrace();
        }

        return response;
    }

}

