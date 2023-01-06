package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameServiceImpl implements GameService{

    @Override
    public int Game(int fishki) {
        Scanner in = new Scanner(System.in);
        int a = (int) (Math.random()*11);
        int stavka = 0, guess = -1;
        while (stavka == 0){
            System.out.print("Сделайте вашу ставку: ");
            stavka = CheckerStavki(fishki);
        }
        while (guess == -1){
            System.out.print("Отлично, теперь угадайте число от 0-9: ");
            guess = CheckerGuess();
        }
        if (a == guess){
            fishki += stavka*10;
            System.out.println("Поздравляю, вы победили! Ваш банк теперь составляет: " + fishki + "!");
        }
        else {
            fishki -= stavka;
            System.out.println("К сожалению, вы проиграли! Загаданное число было: " + a + " Ваш банк теперь составляет: " + fishki + "!");
        }
        if (fishki <= 0){

            System.out.println("Ваши фишки закончились!");
            return 0;
        }
        return fishki;
    }

    @Override
    public int CheckerFishek(int fishki) {
        Scanner in = new Scanner(System.in);
        try{
            int temp = in.nextInt();
            fishki = temp;
        }
        catch (InputMismatchException exception) {
            System.out.println("Это не число!");
            return 0;
        }
        if (fishki <= 0){
            System.out.println("У вас не может быть отрицательное количество фишек или количество фишек равных нулю!");
            return 0;
        }
        else{
            return fishki;
        }
    }

    @Override
    public int CheckerStavki(int fishki) {
        Scanner in = new Scanner(System.in);
        int stavka = 0;
        try{
            int temp = in.nextInt();
            stavka = temp;
        }
        catch (InputMismatchException exception){
            System.out.println("Это не число!");
            return 0;
        }
        if (stavka == -1) {
            System.out.println("Игра окончена! Ваш банк: " + fishki);
            System.exit(0);
        } else if (stavka > fishki | fishki < (fishki-stavka)){
            System.out.println("У вас недостаточно фишек для этой ставки!");
            return 0;
        } else if (stavka <= 0 & stavka != 1) {
            System.out.println("Ставка не может быть равной нулю или быть отрицательной!");
            return 0;
        } else{
            return stavka;
        }
        return 0;
    }

    @Override
    public int CheckerGuess() {
        Scanner in = new Scanner(System.in);
        int guess = -1;
        try{
            int temp = in.nextInt();
            guess = temp;
        }
        catch (InputMismatchException exception){
            System.out.println("Это не число");
            return -1;
        }
        if (guess <= -1){
            System.out.println("Загаданное число не может быть отрицательным!");
            return -1;
        } else if (guess >= 11) {
            System.out.println("Загаданное число не может быть больше 10!");
            return -1;
        }
        else{
            return guess;
        }
    }

    @Override
    public String PrintStartInfo() {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в казино!");
        System.out.print("Введите ваше имя: ");
        String name = in.nextLine();
        System.out.println("Приветсвую, " + name + "!");
        return name;
    }

    @Override
    public void PrintMainInfo() {
        System.out.println("Отлично, теперь поговорим о правилах");
        System.out.println("В начале каждой игры вам будет предложенно поставить ставку на цифру от 0-9");
        System.out.println("В случае, если вы угадываете число, ваша ставка увеличивается в 10 раз!");
        System.out.println("В случае проигрыша, ваша ставка уходит в банк казино");
        System.out.println("Игра продолжается до тех пор, пока у вас не закончаться фишки или вы сами не захотите уйти");
        System.out.println("Если вы заходите закончить игру, то просто сделайте ставку -1!");
        System.out.println("Что же, начнём игру!");
    }


}
