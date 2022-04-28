package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static final String ANNOUNCE = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    public static final String ANNOUNCE_COUNT = "시도할 횟수";
    public static final String WINNER = "최종우승자: ";
    public static final int GO = 4;

    // 4이상일 경우만 전진하도록 다시 구현
    public static void main(String[] args) {
        System.out.println(ANNOUNCE);

        String input = String.valueOf(Console.readLine());
        String[] splits = input.split(",");

        int countNum = count();

        Car[] car = new Car[splits.length];
        makeCar(splits, car);
        go(splits, car, countNum);
        String name = comparisonPosition(splits, car);
        winner(name);

    }

    public static void winner(String name) {
        System.out.println(WINNER + name);
    }

    public static int count() {
        System.out.println(ANNOUNCE_COUNT);
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    public static void go(String splits[], Car[] car, int count) {

      for(int i=0;i<count; i++) {
        for(int j=0; j<splits.length; j++) {
            int randNumber = randNum();
            if (randNumber >= GO) {
                car[j].moveForward(randNumber);
            }
            System.out.println(car[j].getCarName()+":" + car[i].print());
        }
      }
    }

    public static int randNum() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }

    public static void makeCar(String[] splits, Car[] car) {

        for (int i=0; i< splits.length; i++) {
            car[i] = new Car(splits[i]);
        }
    }

    public static String comparisonPosition(String[] splits, Car[] car) {
        int max = car[0].getPosition();
        String name = "";
        for(int i=0; i<splits.length; i++) {
            if(car[i].getPosition() > max) {
                name = car[i].getCarName();
            }
        }
        return name;
    }
}
