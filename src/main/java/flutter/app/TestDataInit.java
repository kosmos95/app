//package flutter.app;
//
//import flutter.app.model.Member;
//import flutter.app.repository.memberRepository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//
//
//
//@Slf4j
//@RequiredArgsConstructor
//public class TestDataInit
//{
//    private final MemberRepository memberRepository;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void initData() {
//        log.info("test data init");
//        for (int i = 0; i < 100; i++) {
//            memberRepository.save(new Member("member" + i, "1234", "고대건" + i, "을해","010-9402-2403", "rheorjs789@naver.com", 1000 + 100*i,"테스트 데이터 삽입"));
//        }
//    }
//}
