package com.example.securitytest.Repository;

import com.example.securitytest.Entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<Member, String> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query(" select m from Member m where m.email = :email")
    Optional<Member> findByEmail(@Param("email") String emial);

}
