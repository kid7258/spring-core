package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드, 해결책은 해당 상태 필드를 없애고 order 함수 내에 price 지역 변수를 return

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제 부분
    }

    public int getPrice() {
        return price;
    }
}
