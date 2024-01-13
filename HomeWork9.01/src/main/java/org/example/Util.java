package org.example;

import java.util.Scanner;
import java.util.Arrays;
import static org.example.Const.*;

public class Util {
    public static void printResult(Integer[] userNums, Integer[] winNums) {
        System.out.println("Пользовательские номера: " + Arrays.toString(userNums));
        System.out.println("Выиграшные номера: " + Arrays.toString(winNums));
        System.out.println("Выиграшных чисел: " + countWinNum(userNums, winNums));
    }

    public static void runLottery() {
        Scanner sc = new Scanner(System.in);
        Integer[][] playersData = new Integer[3][USER_NUM];

        for (int player = 0; player < 3; player++) {
            System.out.println("Игрок " + (player + 1) + ":");
            playersData[player] = inputUserData1(sc);
        }

        Integer[] winData = createWinData();
        System.out.println("Выигрышные номера: " + Arrays.toString(winData));

        for (int i = 0; i < playersData.length; i++) {
            printResult(playersData[i], winData);
        }
    }

    public static Integer[] inputUserData1(Scanner sc) {
        Integer tempNum;
        Integer[] userNums = new Integer[USER_NUM];

        for (int i = 0; i < userNums.length; i++) {
            while (true) {
                System.out.println("Введите " + (i + 1 + " число"));
                tempNum = sc.nextInt();
                if (tempNum < 1 || tempNum > RANGE) {
                    System.out.println("Your number is out of range. Try again.");
                } else {
                    userNums[i] = tempNum;
                    break;
                }
            }
        }
        return userNums;
    }
    public static Integer[] createWinData() {
        Integer[] winNums = new Integer[WIN_NUM];
        for (int i = 0; i < winNums.length; i++) {
            winNums[i] = (int) ((Math.random() * (RANGE - 1)) + 1);
        }
        return winNums;
    }

    public static Integer countWinNum(Integer[] userData, Integer[] winData) {
        Integer winsCount = 0;
        for (int i = 0; i < userData.length; i++) {
            for (int j = 0; j < winData.length; j++) {
                if (userData[i].equals(winData[j])) {
                    winsCount++;
                }
            }
        }
        return winsCount;
    }
}
