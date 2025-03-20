package com.example;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tournament_members")
@IdClass(TournamentMemberId.class)
public class TournamentMember {
    @Id
    @Column(name = "tournament_id")
    private Long tournamentId;
    @Id
    @Column(name = "member_id")
    private Long memberId;

    public TournamentMember() {
    }

    public TournamentMember(Long tournamentId, Long memberId) {
        this.tournamentId = tournamentId;
        this.memberId = memberId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
