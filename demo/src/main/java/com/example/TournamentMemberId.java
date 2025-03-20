package com.example;

import java.io.Serializable;
import java.util.Objects;

public class TournamentMemberId implements Serializable {
    private Long tournamentId;
    private Long memberId;

    public TournamentMemberId() {
    }

    public TournamentMemberId(Long tournamentId, Long memberId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentMemberId that = (TournamentMemberId) o;
        return Objects.equals(tournamentId, that.tournamentId) && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentId, memberId);
    }
}
