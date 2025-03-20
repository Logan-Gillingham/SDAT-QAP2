package com.example;

import com.example.TournamentMember;
import com.example.TournamentMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentMemberRepository extends JpaRepository<TournamentMember, TournamentMemberId> {
}