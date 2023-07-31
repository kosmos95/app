package flutter.app.dto.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Data
public class MemberPrayDto {

    private String ganzi;
    private String name;

    MemberPrayDto(String ganzi, String name) {
        this.ganzi = ganzi;
        this.name = name;
    }
}
