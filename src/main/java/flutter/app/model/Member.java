package flutter.app.model;

import flutter.app.model.enumClass.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Target> targets = new ArrayList<>();

    @Column(name = "user_id")
    private String userId;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_ganzi")
    private String memberGanzi;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "pray_pay")
    private int prayPay;

    @Lob
    @Column(name = "pay_description")
    private String payDescription;

    public Member(String userId, String password, String name, String memberGanzi, String phoneNumber, String memberEmail, int prayPay, String payDescription) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.memberGanzi = memberGanzi;
        this.gender=gender;
        this.phoneNumber = phoneNumber;
        this.memberEmail = memberEmail;
        this.prayPay = prayPay;
        this.payDescription = payDescription;
    }
}
