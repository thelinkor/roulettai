package players.TextPlay;

import Game.Gameplay;

import java.util.Scanner;

public class MainTextPlay {
    public static Scanner input;

    public static void main(String[] args){
        input = new Scanner(System.in);
        TextInputPlayer player = new TextInputPlayer();
        Gameplay game = new Gameplay(player, player);
        int score = game.run();
        System.out.println("You ended the game with a score of: " + score);
        input.close();
    }

}
