package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 추가 기능 구현
    //객체에 메시지를 보냄, 객체 내부에서 설정
    public void moveForward() {
        int randnum = randNum();
        if(randnum >= 4) {
            position++;
        }
    }

    public String print() {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int randNum() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }
}
