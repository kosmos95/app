package flutter.app.repository.mybatis;

import flutter.app.dto.target.TargetSaveDto;
import flutter.app.model.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisTargetRepository implements TargetMapper{

    private final TargetMapper targetMapper;
    @Override
    public Target findName(Long id) {
        return targetMapper.findName(id);
    }


}
