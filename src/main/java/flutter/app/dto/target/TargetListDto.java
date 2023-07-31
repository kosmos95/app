package flutter.app.dto.target;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TargetListDto {

    private String name;
    private String ganzi;

    public TargetListDto() {
    }

    public TargetListDto(String name, String ganzi) {
        this.name = name;
        this.ganzi = ganzi;
    }
}
