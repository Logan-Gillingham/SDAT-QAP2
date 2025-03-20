package com.example;

import com.example.Member;
import com.example.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> searchMembers(String name, String phone, Date startDate) {
        if (name != null) {
            return memberRepository.findByNameContainingIgnoreCase(name);
        } else if (phone != null) {
            return memberRepository.findByPhone(phone);
        } else if (startDate != null) {
            return memberRepository.findByMembershipStartDate(startDate);
        } else {
            return memberRepository.findAll();
        }
    }
}
