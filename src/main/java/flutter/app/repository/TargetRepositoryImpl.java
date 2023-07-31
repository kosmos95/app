package flutter.app.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import flutter.app.dto.target.TargetListDto;
import flutter.app.dto.target.TargetPrayDto;
import flutter.app.dto.target.TargetSearchCondition;

import javax.persistence.EntityManager;
import java.util.List;

import static flutter.app.model.QTarget.*;
import static org.springframework.util.ObjectUtils.isEmpty;


public class TargetRepositoryImpl implements TargetRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public TargetRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public TargetPrayDto findOne(Long id) {
        TargetPrayDto result = queryFactory
                .select(Projections.fields(TargetPrayDto.class,
                        target.targetName.as("name"),
                        target.targetGanzi.as("ganzi")))
                .from(target)
                .where(target.id.eq(id))
                .fetchOne();

        return result;
    }

    /*
    * TargetCharmDto에 기본 생성자가 없으면 에러 난다.
    * */
    @Override
    public List<TargetListDto> findAll(Long id) {
        List<TargetListDto> result = queryFactory
                           .select(Projections.fields(TargetListDto.class,
                        target.targetName.as("name"),
                        target.targetGanzi.as("ganzi")))
//                .select(new QTargetCharmDto(target.targetName, target.targetGanzi))
                .from(target)
                .leftJoin(target.member)
                .where(target.member.id.eq(id))
                .fetch();

        return result;
    }

    @Override
    public List<TargetListDto> search(TargetSearchCondition condition) {
        List<TargetListDto> result = queryFactory
                .select(Projections.fields(TargetListDto.class,
                        target.targetName.as("name"),
                        target.targetGanzi.as("ganzi")))
                .from(target)
                .where(targetNameEq(condition.getName()))
                .fetch();

        return result;
    }

    private BooleanExpression targetNameEq(String targetName) {
        return  isEmpty(targetName) ? null : target.targetName.eq(targetName);
    }

}
