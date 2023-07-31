package flutter.app.repository.mybatis;

import flutter.app.dto.target.TargetSaveDto;
import flutter.app.model.Target;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TargetMapper {

    Target findName(Long id);

//    void save(Target target);
//
//    //파라미터가 두개 이상 넘어갈 때는 @Param 넣어야 한다.
//    void update(@Param("id") Long id, @Param("updateParam") TargetSaveDto targetSaveDto);
//
//    Optional<Target> findById(Long id);
}
