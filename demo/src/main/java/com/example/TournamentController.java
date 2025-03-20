package com.example;

import com.example.Member;
import com.example.Tournament;
import com.example.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament createdTournament = tournamentService.createTournament(tournament);
        return new ResponseEntity<>(createdTournament, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id)
                .map(tournament -> new ResponseEntity<>(tournament, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tournament>> searchTournaments(
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) String location) {

        List<Tournament> tournaments = tournamentService.searchTournaments(startDate, location);
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    @PostMapping("/{tournamentId}/members/{memberId}")
    public ResponseEntity<Void> addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        tournamentService.addMemberToTournament(tournamentId, memberId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{tournamentId}/members")
    public ResponseEntity<List<Member>> getMembersInTournament(@PathVariable Long tournamentId) {
        List<Member> members = tournamentService.getMembersInTournament(tournamentId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
