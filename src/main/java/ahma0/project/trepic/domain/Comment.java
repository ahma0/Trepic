package ahma0.project.trepic.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member memberId;

    @ManyToOne
    @JoinColumn(name = "diary_id", referencedColumnName = "diary_id")
    private Diary diaryId;

    @Builder
    public Comment(String content, Member memberId, Diary diaryId) {
        this.content = content;
        this.memberId = memberId;
        this.diaryId = diaryId;
    }
}
