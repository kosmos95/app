package flutter.app.repository.memberRepository;

import flutter.app.dto.member.MemberInfoDto;

public interface MemberRepositoryCustom {

    public MemberInfoDto memberInfo(Long id);
}
