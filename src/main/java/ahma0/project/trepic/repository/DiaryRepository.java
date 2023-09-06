package ahma0.project.trepic.repository;

import ahma0.project.trepic.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
