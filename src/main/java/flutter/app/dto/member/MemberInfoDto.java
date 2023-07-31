package flutter.app.dto.member;

import flutter.app.model.enumClass.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemberInfoDto {

    private String name;

    private String ganzi;

    private Gender gender;

    private String phoneNumber;

    private String email;

    private Long pay;

    private String description;

    public MemberInfoDto() {
    }

    public MemberInfoDto(String name, String ganzi, Gender gender, String phoneNumber, String email, Long pay, String description) {
        this.name = name;
        this.ganzi = ganzi;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pay = pay;
        this.description = description;
    }
}
