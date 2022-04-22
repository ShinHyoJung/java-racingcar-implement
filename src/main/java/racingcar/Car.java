package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name, int position) {

        this.name = name;
        this.position = position;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 추가 기능 구현
}
