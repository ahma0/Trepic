package ahma0.project.trepic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @NotBlank
    @Column(length = 10, nullable = false)
    private String idUsedByMember;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Email
    @Column(length = 30, nullable = false)
    private String email;

    @Column
    private String profile;

    @Builder
    public Member(String idUsedByMember, String password, String nickname, String email, String profile) {
        this.idUsedByMember = idUsedByMember;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profile = profile;
    }
}
