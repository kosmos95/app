package flutter.app.dto.target;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TargetPrayDto {

    private String name;

    private String ganzi;

    public TargetPrayDto() {
    }


    public TargetPrayDto(String name, String ganzi) {
        this.name = name;
        this.ganzi = ganzi;
    }
}
