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

        int countNum = count();
        int num = countNum * splits.length;
        int cipher = num;

        Car [][] car = new Car[splits.length][countNum];

        int [] positions = makeCar(countNum, splits, car, cipher);
        int max = comparisonPosition(positions);
        winner(splits, countNum, max, car);
    }

    public static void winner(String[] splits, int countNum, int max, Car[][] car) {
        for(int i=0; i< splits.length; i++) {
            for (int j = 0; j < countNum; j++) {
                if (car[i][j].getPosition() == max) {
                    System.out.println(WINNER + car[i][j].getCarName());
                }
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

    public static int[] makeCar(int count, String[] splits, Car[][] car, int cipher) {
        int [] positions = new int[cipher];
        int num;
        for (int i = 0; i <= count; i++) {
            num = 0;
            for (String j : splits) {
                int randNumber = randNum();
                String go = go(randNumber);
                car[i][num] = new Car(j, randNumber);
                positions[i] = randNumber;
                System.out.println(car[i][num].getCarName() + ":" + go + car[i][num].getPosition());
                num++;
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
