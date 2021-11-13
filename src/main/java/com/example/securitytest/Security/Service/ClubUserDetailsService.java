package com.example.securitytest.Security.Service;

import com.example.securitytest.Entity.Member;
import com.example.securitytest.Repository.ClubMemberRepository;
import com.example.securitytest.Security.DTO.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClubUserDetailsService implements UserDetailsService {

    private final ClubMemberRepository clubMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username is " + username);

        Optional<Member> result = clubMemberRepository.findByEmail(username);

        if(!result.isPresent()) {
            log.info("error happened");
            throw new UsernameNotFoundException("Check Email or Social");
        }

        Member member = result.get();

        log.info("-----------------------");
        log.info(member);

        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO(
                member.getEmail(),
                member.getRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toSet())
        );

        clubAuthMemberDTO.setName(member.getName());

        return clubAuthMemberDTO;

    }
}
