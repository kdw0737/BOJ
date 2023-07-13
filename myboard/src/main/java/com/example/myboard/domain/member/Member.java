package com.example.myboard.domain.member;

import com.example.myboard.domain.BaseTimeEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "MEMBER")


public class Member extends BaseTimeEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id; //primary Key

    @Column(nullable = false, length = 30, unique = true)
    private String username;//아이디

    @Column(nullable = false, length = 100)
    private String password;//비밀번호

    @Column(nullable = false, length = 30)
    private String name;//이름(실명)

    @Column(nullable = false, length = 30)
    private String nickName;//별명

    @Column(nullable = false, length = 30)
    private Integer age;//나이

    @Enumerated(EnumType.STRING)
    private Role role;//권한 -> USER, ADMIN

    @Column(length = 1000)
    private String refreshToken;//RefreshToken

    public void updatePassword(PasswordEncoder passwordEncoder, String password){
        this.password = passwordEncoder.encode(password);
    }


    //== 정보 수정 ==//
    public void updateName(String name){
        this.name = name;
    }

    public void updateNickName(String nickName){
        this.nickName = nickName;
    }

    public void updateAge(int age){
        this.age = age;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
    public void destroyRefreshToken(){
        this.refreshToken = null;
    }


    //== 패스워드 암호화 ==//
    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
