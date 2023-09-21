package ahma0.project.trepic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Diary extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id", nullable = false)
    private Long diaryId;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member writer;

    @Builder
    public Diary(String title, String content, Member writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
