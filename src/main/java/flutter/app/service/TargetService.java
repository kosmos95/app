package flutter.app.service;

import flutter.app.dto.target.TargetListDto;
import flutter.app.dto.target.TargetPrayDto;
import flutter.app.dto.target.TargetSaveDto;
import flutter.app.dto.target.TargetSearchCondition;
import flutter.app.model.Target;
import flutter.app.repository.TargetRepository;
import flutter.app.repository.mybatis.MybatisTargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TargetService {

    @PersistenceContext
    EntityManager em;

    private final TargetRepository targetRepository;

    private final MybatisTargetRepository mybatisTargetRepository;

    public Target save(Target target) {
        targetRepository.save(target);
        return target;
    }

    public Target findTarget(Long id) {
        return targetRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public TargetPrayDto findOne(Long id) {
        return targetRepository.findOne(id);
    }

     //마이바티스 설정
//    public Target findTargetName(Long id) {
//        return mybatisTargetRepository.findName(id);
//    }

    public void deleteTarget(Long id) {
        targetRepository.deleteById(id);
    }

    public void update(Long id, TargetSaveDto targetSaveDto) {
        Target target = targetRepository.findById(id).orElseThrow(IllegalArgumentException::new);;
        target.updateTarget(target, targetSaveDto);
    }

    public List<TargetListDto> finaAll(Long id) {
        return targetRepository.findAll(id);
    }

    public List<TargetListDto> search(TargetSearchCondition condition) {
        return targetRepository.search(condition);
    }

}
