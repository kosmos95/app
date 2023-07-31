package flutter.app.model;

import flutter.app.dto.target.TargetSaveDto;
import flutter.app.model.enumClass.CulturalGrade;
import flutter.app.model.enumClass.Gender;
import flutter.app.model.enumClass.Root;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "target")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Target {

    @Id
    @Column(name = "target_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "target_name")
    private String targetName;

    @Column(name = "target_ganzi")
    private String targetGanzi;

    @Column(name = "target_phoneNumber")
    private String targetPhoneNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "root")
    @Enumerated(EnumType.STRING)
    private Root root;

    @Enumerated(EnumType.STRING)
    private CulturalGrade culturalGrade;

    @Column(name = "target_email")
    private String email;

    @Column(name = "start_day")
    private LocalDateTime startDay;

    @Column(name = "expected_day")
    private LocalDateTime expectedDay;

     /*
    *  값 타입 컬렉션 매핑
    *  jpa가 별도의 테이블을 만들어 관리한다. 설정은 @CollectionTable
    *  값 타입 컬렉션은 조회 시 지연로딩 전략을 사용합니다.
    *  값 타입은 그 생명주기를 부모 엔티티에 의해 관리된다.
    *  즉 영속성 전이(Cascade ALL) + 고아 객체 제거 기능을 필수로 가진다고 볼 수 있다.
    * */
    @ElementCollection(fetch = LAZY)
    @CollectionTable(name="target_status", joinColumns = @JoinColumn(name= "target_id", referencedColumnName = "target_id"))
    private List<String> status;

    @Lob
    @Column(name = "Description")
    private String description;

    public Target saveTarget(TargetSaveDto targetSaveDto, Member member) {
        Target target = new Target();

        target.setMember(member);
        target.setTargetName(targetSaveDto.getTargetName());
        target.setTargetGanzi(targetSaveDto.getGanzi());
        target.setTargetPhoneNumber(targetSaveDto.getTargetPhoneNumber());
        target.setGender(targetSaveDto.getGender());
        target.setRoot(targetSaveDto.getRoot());
        target.setCulturalGrade(targetSaveDto.getCulturalGrade());
        target.setEmail(targetSaveDto.getEmail());
        target.setStartDay(targetSaveDto.getStartDay());
        target.setExpectedDay(targetSaveDto.getExpectedDay());
        target.setStatus(targetSaveDto.getStatus());
        target.setDescription(targetSaveDto.getDescription());

        return target;
    }

    public void updateTarget(Target target, TargetSaveDto targetSaveDto) {
        target.setTargetName(targetSaveDto.getTargetName());
        target.setTargetGanzi(targetSaveDto.getGanzi());
        target.setTargetPhoneNumber(targetSaveDto.getTargetPhoneNumber());
        target.setGender(targetSaveDto.getGender());
        target.setRoot(targetSaveDto.getRoot());
        target.setCulturalGrade(targetSaveDto.getCulturalGrade());
        target.setEmail(targetSaveDto.getEmail());
        target.setStartDay(targetSaveDto.getStartDay());
        target.setExpectedDay(targetSaveDto.getExpectedDay());
        target.setStatus(targetSaveDto.getStatus());
        target.setDescription(targetSaveDto.getDescription());
    }

}

