package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 이 걸려있을 경우 CGLIB에서 해당 클래스의 자식 클래스를 별도로 만들어서 관리하기 때문에 싱글톤이 보장 됨
@Configuration // @Configuration 제거 시, 스프링 빈으로는 등록이 되지만 싱글톤을 보장하지 않음
public class AppConfig {

    @Bean // @Bean 추가 시, 스프링 컨테이너에서 관리 됨
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
