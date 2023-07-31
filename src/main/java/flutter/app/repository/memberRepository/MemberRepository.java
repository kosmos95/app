package flutter.app.repository.memberRepository;

import flutter.app.model.Member;
import flutter.app.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    List<Member> findByName(String name);

    @Query("select m from Member m where m.id = :id")
    Member findName(@Param("id") Long id);


}