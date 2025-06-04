package org.example.itcen_semi_project.member.service;

import org.example.itcen_semi_project.member.domain.Member;
import org.example.itcen_semi_project.member.domain.dto.MemberDTO;

public interface MemberService {

    boolean newMember(MemberDTO member);
    Member loginMember(MemberDTO member);

}

