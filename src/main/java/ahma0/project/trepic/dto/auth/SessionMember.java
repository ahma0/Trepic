package ahma0.project.trepic.dto.auth;

import ahma0.project.trepic.domain.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {

    private String nickname;
    private String email;
    private String picture;

    public SessionMember(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.picture = member.getProfile();
    }
}
