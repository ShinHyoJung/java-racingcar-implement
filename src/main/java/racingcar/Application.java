package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static final String ANNOUNCE = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    public static final String ANNOUNCE_COUNT = "시도할 횟수";
    public static final String WINNER = "최종우승자: ";
    public static final String NEXT = ",";

    // 4이상일 경우만 전진하도록 다시 구현
    public static void main(String[] args) {
        System.out.println(ANNOUNCE);

        String input = String.valueOf(Console.readLine());

        if(input.getClass().getName() != "java.lang.String") {
            throw new IllegalArgumentException("[ERROR] 문자열을 입력해주세요.");
        }
        String[] splits = input.split(",");

        int countNum = count();

        Car[] car = new Car[splits.length];
        makeCar(splits, car);
        go(splits, car, countNum);
        String[] names = comparisonPosition(splits, car);
        winner(names);

    }

    public static void winner(String[] names) {

        StringBuffer sb = new StringBuffer();

        for(String name : names) {
            if(name != null) {
                sb.append(name);
                sb.append(NEXT);
            }
        }
        System.out.println(WINNER + sb);
    }

    public static int count() {
        System.out.println(ANNOUNCE_COUNT);
        int count = Integer.parseInt(Console.readLine());

      return count;
    }

    public static void go(String splits[], Car[] car, int count) {

      for(int i=0;i<count; i++) {
        for(int j=0; j<splits.length; j++) {
            car[j].moveForward();
            System.out.println(car[j].getCarName()+":" + car[j].print());
        }
      }
    }

    public static void makeCar(String[] splits, Car[] car) {

        for (int i=0; i< splits.length; i++) {
            car[i] = new Car(splits[i]);
        }
    }

    public static String[] comparisonPosition(String[] splits, Car[] car) {
        int max = car[0].getPosition();
        String[] names = new String[splits.length];
        int k = 0;
        for(int i=0; i<splits.length;i++) {
            if(car[i].getPosition() > max) {
                names[k] = car[i].getCarName();
                k++;
            }
        }
        return names;
    }
}
