package com.example;

import com.example.Member;
import com.example.Tournament;
import com.example.TournamentMember;
import com.example.MemberRepository;
import com.example.TournamentMemberRepository;
import com.example.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentMemberRepository tournamentMemberRepository;

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> searchTournaments(Date startDate, String location) {
        if (startDate != null) {
            return tournamentRepository.findByStartDate(startDate);
        } else if (location != null) {
            return tournamentRepository.findByLocationContainingIgnoreCase(location);
        } else {
            return tournamentRepository.findAll();
        }
    }

    public void addMemberToTournament(Long tournamentId, Long memberId) {
        TournamentMember tournamentMember = new TournamentMember(tournamentId, memberId);
        tournamentMemberRepository.save(tournamentMember);
    }

    public List<Member> getMembersInTournament(Long tournamentId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (tournamentOptional.isPresent()) {
            Tournament tournament = tournamentOptional.get();
            return tournament.getMembers().stream().collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}