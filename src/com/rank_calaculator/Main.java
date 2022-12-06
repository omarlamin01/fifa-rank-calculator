package com.rank_calaculator;

import com.rank_calaculator.enums.*;
import com.rank_calaculator.models.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Team[] group_f = new Team[4];

        Team team = new Team();
        team.setScore(1563.5F);
        team.setAbreviation("MAR");

        group_f[0] = team;

        team = new Team();
        team.setScore(1816.71F);
        team.setAbreviation("BEL");

        group_f[1] = team;

        team = new Team();
        team.setScore(1645.64F);
        team.setAbreviation("CRO");

        group_f[2] = team;

        team = new Team();
        team.setScore(1475.00F);
        team.setAbreviation("CAN");

        group_f[3] = team;

        Game[] group_f_games = new Game[6];

//      MAR v CRO
        Game game = new Game();
        game.setA(group_f[0]);
        game.setB(group_f[2]);
        game.setResult(Results.DRAW);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[0] = game;

//      BEL v CAN
        game = new Game();
        game.setA(group_f[1]);
        game.setB(group_f[3]);
        game.setResult(Results.WIN);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[1] = game;

//      MAR v BEL
        game = new Game();
        game.setA(group_f[0]);
        game.setB(group_f[1]);
        game.setResult(Results.WIN);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[2] = game;

//      CRO v CAN
        game = new Game();
        game.setA(group_f[2]);
        game.setB(group_f[3]);
        game.setResult(Results.WIN);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[3] = game;

//      MAR v CAN
        game = new Game();
        game.setA(group_f[0]);
        game.setB(group_f[3]);
        game.setResult(Results.WIN);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[4] = game;

//      BEL v CRO
        game = new Game();
        game.setA(group_f[1]);
        game.setB(group_f[2]);
        game.setResult(Results.DRAW);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_f_games[5] = game;

        Team[] group_h = new Team[4];

        team = new Team();
        team.setScore(1715.22F);
        team.setAbreviation("ESP");

        group_h[0] = team;

        team = new Team();
        team.setScore(1650.21F);
        team.setAbreviation("GER");

        group_h[1] = team;

        team = new Team();
        team.setScore(1559.54F);
        team.setAbreviation("JPN");

        group_h[2] = team;

        team = new Team();
        team.setScore(1503.59F);
        team.setAbreviation("CRC");

        group_h[3] = team;

        Game[] group_h_games = new Game[6];

//      GER v JPN
        game = new Game();
        game.setA(group_h[1]);
        game.setB(group_h[2]);
        game.setResult(Results.LOSE);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[0] = game;

//      ESP v CRC
        game = new Game();
        game.setA(group_h[0]);
        game.setB(group_h[3]);
        game.setResult(Results.WIN);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[1] = game;

//      JPN v CRC
        game = new Game();
        game.setA(group_h[2]);
        game.setB(group_h[3]);
        game.setResult(Results.LOSE);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[2] = game;

//      ESP v GER
        game = new Game();
        game.setA(group_h[0]);
        game.setB(group_h[1]);
        game.setResult(Results.DRAW);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[3] = game;

//      CRC v GER
        game = new Game();
        game.setA(group_h[3]);
        game.setB(group_h[1]);
        game.setResult(Results.LOSE);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[4] = game;

//      ESP v JPN
        game = new Game();
        game.setA(group_h[0]);
        game.setB(group_h[2]);
        game.setResult(Results.LOSE);
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        group_h_games[5] = game;

        for (Game match : group_f_games) {
            System.out.println(match.getA().getAbreviation() + " vs " + match.getB().getAbreviation());
            match.updateScore();
            System.out.println(match.getA().getAbreviation() + " score is " + (match.getA().getScore()));
            System.out.println(match.getB().getAbreviation() + " score is " + (match.getB().getScore()));
            System.out.println();
            System.out.println("**********************************************");
            System.out.println();
        }

        for(Game match :group_h_games) {
            System.out.println(match.getA().getAbreviation() + " vs " + match.getB().getAbreviation());
            match.updateScore();
            System.out.println(match.getA().getAbreviation() + " score is " + (match.getA().getScore()));
            System.out.println(match.getB().getAbreviation() + " score is " + (match.getB().getScore()));
            System.out.println();
            System.out.println("**********************************************");
            System.out.println();
        }
    }

}
