package com.gg.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    PasswordEncoder pwdEncoder;

    @Autowired
    JavaMailSender emailSender;// 자체적으로 지원하는 기능

    @Value("${spring.mail.username}")
    private String sender;

    /* 로그인 성공 시 정보가져오기 */
    @Override
    public MemberDTO loginAction(String mem_id) {
        return loginMapper.loginAction(mem_id);
    }

    /* 로그인 성공여부 판단 체크 */
    @Override
    public int loginCheck(String mem_id, String mem_pass) {
        MemberDTO matchDTO = loginMapper.loginAction(mem_id);

        if (matchDTO == null) {
            return 2;
        } else if (!pwdEncoder.matches(mem_pass, matchDTO.getMem_pass())) {
            return 0;
        }
        return 1;
    }

    /* 아이디 찾기 */
    @Override
    public String forgotIdCheck(String mem_name, String mem_hp) {
        return loginMapper.forgotIdCheck(mem_name, mem_hp);
    }

    /* 비밀번호 찾기 */
    @Override
    public int forgotPassCheck(MemberDTO dto) {
        MemberDTO mailDTO = loginMapper.mailAction(dto);

        if (mailDTO == null) {
            return 0;
        }
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        String newPass = generatedString;

        String encNewPassword = pwdEncoder.encode(newPass); // 암호화
        dto.setMem_pass(encNewPassword);

        loginMapper.forgotPassCheck(dto);

        String toyou = mailDTO.getMem_email1() + "@" + mailDTO.getMem_email2();

        // 메세지를 생성하고 보낼 메일 설정 저장
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toyou);
        message.setFrom(sender);
        message.setSubject("안녕! " + dto.getMem_name() + "야 임시비밀번호를 알려줄게~~");
        message.setText("임시비밀번호는 " + newPass + " 입니다.");
        emailSender.send(message);

        return 1;

    }

}