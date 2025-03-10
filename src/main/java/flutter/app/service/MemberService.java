package flutter.app.service;

import flutter.app.dto.member.MemberInfoDto;
import flutter.app.model.Member;
import flutter.app.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional() //defalt 값은 readOnly = flase
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //EXCETPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public Member findMember(Long id) {
        return memberRepository.findName(id);
    }


//    회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 단건 조회1
    //public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

    public MemberInfoDto memberInfo(Long id) {
        return memberRepository.memberInfo(id);
    }
}
