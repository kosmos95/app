package flutter.app.dto.target;

import flutter.app.model.Target;
import flutter.app.model.enumClass.CulturalGrade;
import flutter.app.model.enumClass.Gender;
import flutter.app.model.enumClass.Root;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter
public class TargetInfoDto {

    private String targetName;

    private String ganzi;

    private Gender gender;

    private Root root;

    private CulturalGrade culturalGrade;

    private String targetPhoneNumber;

    private String email;

    private String description;

    private List<String> status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime expectedDay;

    public TargetInfoDto targetDtoInfo(Target target) {

        TargetInfoDto targetInfoDto = new TargetInfoDto();

        targetInfoDto.setTargetName(target.getTargetName());
        targetInfoDto.setGanzi(target.getTargetGanzi());
        targetInfoDto.setGender(target.getGender());
        targetInfoDto.setRoot(target.getRoot());
        targetInfoDto.setCulturalGrade(target.getCulturalGrade());
        targetInfoDto.setTargetPhoneNumber(target.getTargetPhoneNumber());
        targetInfoDto.setEmail(target.getEmail());
        targetInfoDto.setDescription(target.getDescription());
        targetInfoDto.setStatus(target.getStatus());
        targetInfoDto.setStartDay(target.getStartDay());
        targetInfoDto.setExpectedDay(target.getExpectedDay());

        return targetInfoDto;
    }
}
