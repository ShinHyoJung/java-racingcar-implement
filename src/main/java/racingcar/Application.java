package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static final String ANNOUNCE = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    public static final String ANNOUNCE_COUNT = "시도할 횟수";
    public static final String WINNER = "최종우승자: ";
    public static final String NEXT = ",";

    // 4이상일 경우만 전진하도록 다시 구현
    public static void main(String[] args) {
        System.out.println(ANNOUNCE);
        List<String> splits = new ArrayList();

        while(true) {
            try {
                String input = String.valueOf(Console.readLine());
                String[] inputs = input.split(",");
                splits = Arrays.asList(inputs);

                checkStringValidity(splits);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 이름은 5자이하로 입력해주세요.");
            }
        }

        int countNum = count();

        System.out.println(splits.size());
        List<Car> car = makeCar(splits);


        go(car, countNum);
        List<String> names = comparisonPosition(car);
        winner(names);

    }

    public static void checkStringValidity(List<String> splits) {
        for(String name: splits) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int checkNumberValidity() {
        int count;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    public static void winner(List<String> names) {

        StringBuilder sb = new StringBuilder();

        for(String name : names) {
            if(name != null) {
                sb.append(name);
                sb.append(NEXT);
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(WINNER + sb.toString());
    }

    public static int count() {
        System.out.println(ANNOUNCE_COUNT);
        int count = 0;
        while (true) {
            try {
                count = checkNumberValidity();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
            return count;
        }
    }

    public static void go(List<Car> car, int count) {

      for(int i=0;i<count; i++) {
        for(int j=0; j<car.size(); j++) {
            car.get(j).moveForward();
            System.out.println(car.get(j).getCarName()+":" + car.get(j).print());
        }
      }
    }

    public static List<Car> makeCar(List<String> splits) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i< splits.size(); i++) {
            Car car = new Car(splits.get(i));
            cars.add(car);
        }
        return cars;
    }

    public static List<String> comparisonPosition(List<Car> car) {
        List<String> names = new ArrayList<>();
        int max = car.get(0).getPosition();

        int k=0;
        for(int i=0; i<car.size();i++) {
            if(car.get(i).getPosition() > max) {
                names.add(k, car.get(i).getCarName());
                k++;
            }
        }
        return names;
    }
}
