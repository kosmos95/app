package flutter.app.api;

import flutter.app.dto.target.*;
import flutter.app.model.Member;
import flutter.app.model.Target;
import flutter.app.service.MemberService;
import flutter.app.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TargetApiController {

    private final MemberService memberService;
    private final TargetService targetService;

    //대상자 등록
    @PostMapping("/api/target/{id}")
    public Long saveTarget(@RequestBody @Valid TargetSaveDto targetSaveDto, Target target, @PathVariable("id") Long id) {

        Member member = memberService.findMember(id);

        Target target1 = target.saveTarget(targetSaveDto, member);
        targetService.save(target1);

        return target1.getId();
    }

    //대상자 전체 정보 읽어 오기
    @GetMapping("/api/target/{id}")
    public TargetInfoDto TargetInfo(@PathVariable("id") Long id, TargetInfoDto targetInfoDto) {

        Target findTarget = targetService.findTarget(id);

        targetInfoDto = targetInfoDto.targetDtoInfo(findTarget);

        return targetInfoDto;
    }

    //대상자 수정
    @PutMapping("/api/target/{id}")
    public void UpdateTarget(@PathVariable("id") Long id, @RequestBody @Valid TargetSaveDto targetSaveDto) {
        targetService.update(id, targetSaveDto);
    }

    //대상자 삭제
    @DeleteMapping("/api/target/{id}")
    public void deleteTarget(@PathVariable("id") Long id) {
        targetService.deleteTarget(id);
    }

    /*
     * 기도문에 넣을 대상자 00생 000 가져오기
     *
     * */

    @GetMapping("/api/target/pray/{id}")
    public TargetPrayDto TargetPray(@PathVariable("id") Long id) {

        TargetPrayDto targetPrayDto = targetService.findOne(id);

        return targetPrayDto;
    }

    //전체 대상자 읽어오기
    @GetMapping("/api/targets/{id}")
    public List<TargetListDto> findTargetAll(@PathVariable("id") Long id) {

        return targetService.finaAll(id);
    }

    //대상자 이름으로 검색
    @GetMapping("/api/search/{name}")
    public List<TargetListDto> findTargetByName(@PathVariable("name") String name) {
        TargetSearchCondition condition = new TargetSearchCondition();
        condition.setName(name);
        List<TargetListDto> searchResult = targetService.search(condition);

        return searchResult;
    }

}
