package ahma0.project.trepic.repository;

import ahma0.project.trepic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByIdUsedByMember(String idUsedByMember);
}
