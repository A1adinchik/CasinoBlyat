package org.example;

import java.util.Scanner;

public class Main {

    Scanner in = new Scanner(System.in);
    static GameServiceImpl gameService = new GameServiceImpl();

    public static void main(String[] args) {
        boolean start = true;
        int fishki = 0;
        String name = gameService.PrintStartInfo();
        while (fishki == 0){
            System.out.print("Введите сумму ваших фишек: ");
            fishki = gameService.CheckerFishek(fishki);
        }
        gameService.PrintMainInfo();
        while (start) {
            fishki = gameService.Game(fishki);
            if (fishki == 0){
                start = false;
            }
        }
    }
}