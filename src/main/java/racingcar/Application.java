package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static final String ANNOUNCE = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    public static final String ANNOUNCE_COUNT = "시도할 횟수";
    public static final String WINNER = "최종우승자: ";

    public static void main(String[] args) {
        System.out.println(ANNOUNCE);

        String input = String.valueOf(Console.readLine());
        String[] splits = input.split(",");

        Car [] car = new Car[splits.length];

        int countNum = count();
        int num = countNum * splits.length;
        int cipher = num;

        int [] positions = print(countNum, splits, car, cipher);
        int max = comparisonPosition(positions);
        winner(splits, max, car);
    }

    public static void winner(String[] splits, int max, Car[] car) {
        for(int i=0; i< splits.length; i++) {
            if(car[i].getPosition() == max) {
                System.out.println(WINNER + car[i].getCarName());
            }
        }
    }

    public static int count() {
        System.out.println(ANNOUNCE_COUNT);
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    public static String go(int randNumber) {
        StringBuffer sb = new StringBuffer();

        if(randNumber >=4) {
            for (int i = 0; i < randNumber; i++) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public static int randNum() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }

    public static int[] print(int count, String[] splits, Car[] car, int cipher) {
        int [] positions = new int[cipher];
        int num = 0;
        for (int i = 0; i < count; i++) {
            for (String j : splits) {
                int randNumber = randNum();
                String go = go(randNumber);
                car[i] = new Car(j, randNumber);
                positions[num] = randNumber;
                num++;

                System.out.println(car[i].getCarName() + ":" + go + car[i].getPosition());
            }
        }
        return positions;
    }

    public static int comparisonPosition(int[] positions) {
        int max = positions[0];

        for (int i = 0; i < positions.length; i++) {
                if (positions[i] > max) {
                    max = positions[i];
                }
        }
        return max;
    }
}
