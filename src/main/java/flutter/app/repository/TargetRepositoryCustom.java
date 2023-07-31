package flutter.app.repository;

import flutter.app.dto.target.TargetListDto;
import flutter.app.dto.target.TargetPrayDto;
import flutter.app.dto.target.TargetSearchCondition;

import java.util.List;

public interface TargetRepositoryCustom {

    TargetPrayDto findOne(Long id);

    List<TargetListDto> findAll(Long id);

    List<TargetListDto> search(TargetSearchCondition condition);
}
