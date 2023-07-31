package flutter.app.repository.memberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import flutter.app.dto.member.MemberInfoDto;
import flutter.app.model.QMember;

import javax.persistence.EntityManager;

import java.util.List;

import static flutter.app.model.QMember.*;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public MemberInfoDto memberInfo(Long id) {
        MemberInfoDto result = queryFactory
                .select(Projections.fields(MemberInfoDto.class,
                        member.name.as("name"),
                        member.memberGanzi.as("ganzi"),
                        member.gender.as("gender"),
                        member.phoneNumber.as("phoneNumber"),
                        member.memberEmail.as("email"),
                        member.prayPay.as("pay"),
                        member.payDescription.as("description")))
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();

        return result;
    }

}
