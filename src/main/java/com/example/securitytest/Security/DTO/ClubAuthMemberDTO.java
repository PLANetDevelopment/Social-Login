package com.example.securitytest.Security.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User implements OAuth2User {

    private String email;

    private String name;

    // OAuth2User 타입을 ClubAuthMemberDTO 타입으로 사용할 수 있도록 처리
    // OAuth2USer은 Map 타입으로 인증 결과를 받는다.
    private Map<String, Object> attr;

    public ClubAuthMemberDTO(String username,
                             Collection<? extends GrantedAuthority> authorities,
                             Map<String, Object> attr) {

        this(username, authorities);
        this.attr = attr;

    }

    public ClubAuthMemberDTO(String username,
                             Collection<? extends GrantedAuthority> authorities) {
        // 소셜 로그인은 비밀번호를 저장하지 않기 때문에 password로 아무값이나 넣는다.
        super(username, "1111", authorities);
        this.email = username;
    }

    public Map<String, Object> getAttributes() {
        return this.attr;
    }

}
