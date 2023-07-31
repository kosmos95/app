package flutter.app.dto.target;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import flutter.app.model.enumClass.CulturalGrade;
import flutter.app.model.enumClass.Gender;
import flutter.app.model.enumClass.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TargetSaveDto {

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
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") 이거 안됨
    private LocalDateTime startDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime expectedDay;

}
