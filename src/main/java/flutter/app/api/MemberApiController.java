package flutter.app.api;

import flutter.app.dto.member.MemberInfoDto;
import flutter.app.dto.member.MemberPrayDto;
import flutter.app.model.Member;
import flutter.app.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    //@RequestBody : json data -> member 바꿔줌
//    @PostMapping("/api/members")
//    public CreateMemberResponse saveMemberV1(@RequestBody @Valid CreateMemberRequest request) {
//        Member member = new Member();
//        member.setName(request.getName());
//
//        Long memberKey = memberService.join(member);
//        return new CreateMemberResponse(memberKey);
//    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }
    @Data
    static class CreateMemberResponse {
        private Long memberKey;

        CreateMemberResponse(Long memberKey) {
            this.memberKey = memberKey;
        }
    }

    @GetMapping("api/members")
    public List<Member> members() {
        return memberService.findMembers();
    }


    @GetMapping("/api/member/{id}")
    public MemberPrayDto findMember(@PathVariable("id") Long id, MemberPrayDto memberPrayDto){

        Member findMember = memberService.findMember(id);

        memberPrayDto.setGanzi(findMember.getMemberGanzi());
        memberPrayDto.setName(findMember.getName());

        return memberPrayDto;
    }

    @GetMapping("/api/member/info/{id}")
    public MemberInfoDto memberInfo(@PathVariable("id") Long id) {
        return memberService.memberInfo(id);
    }


}

