package ahma0.project.trepic.service;


import ahma0.project.trepic.domain.Member;
import ahma0.project.trepic.dto.MemberRequestDto;
import ahma0.project.trepic.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdCheck {

    private final MemberRepository memberRepository;

    public static String generateRandomId() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public String generateRandomIdAndCheckDuplicate() {
        String id = generateRandomId();

        while(!isDuplicated(id))
            id = generateRandomId();

        return id;
    }

    public boolean isDuplicated(String id) {
        Member member = memberRepository.findMemberByIdUsedByMember(id).orElse(null);
        return member == null;
    }

}
