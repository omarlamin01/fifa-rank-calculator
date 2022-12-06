package com.rank_calaculator.models;

import com.rank_calaculator.enums.Results;
import com.rank_calaculator.enums.Types;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Game {
    private Team A;
    private Team B;
    private Results result;
    private Types type;

    public Team getA() {
        return A;
    }

    public void setA(Team a) {
        A = a;
    }

    public Team getB() {
        return B;
    }

    public void setB(Team b) {
        B = b;
    }

    public Results getResult() {
        return result;
    }

    public void setResult(Results result) {
        this.result = result;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public float calcGameResultCoeff() {
        if (result != null) {
            switch (result) {
                case WIN -> {
                    return 1;
                } case DRAW -> {
                    return 0.5F;
                } case LOSE -> {
                    return 0;
                }default -> {
                    return -1;
                }
            }
        } else
            return -1;
    }

    public int calcGameTypeCoeff() {
        if (type != null) {
            return switch (type) {
                case FRIENDLY_OUT_INTERNATIONAL_CALENDAR -> 5;
                case FRIENDLY_DURING_INTERNATIONAL_CALENDAR -> 10;
                case GROUP_PHASE_OF_NATIONAL_LEAGUE -> 15;
                case PLAY_OFF_AND_FINAL_OF_NATIONAL_LEAGUE -> 25;
                case QUALIFICATION_MATCHES_FOR_CONFEDERATIONS_AND_WORLD_CUP -> 25;
                case CONFEDERATION_FINAL_UNTIL_QF_STAGES -> 35;
                case CONFEDERATION_FINAL_FROM_QF_STAGES -> 40;
                case FIFA_CONFEDERATIONS_CUP_MATCHES -> 40;
                case FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES -> 50;
                case FIFA_WORLD_CUP_FROM_QF_STAGES -> 60;
                default -> -1;
            };
        } else {
            return -1;
        }
    }

    public float calcExpectedResult(Team A, Team B) {
        float diff = A.getScore() - B.getScore();
        return (float) (1 / (pow(10, (-diff/600)) + 1));
    }

   public float calcGameScore(Team A, Team B, float res) {
        return calcGameTypeCoeff() * (res - calcExpectedResult(A, B));
   }

   public void updateScore() {
        switch (result) {
            case WIN -> {
                A.setScore(A.getScore() + calcGameScore(A, B, 1));
                B.setScore(B.getScore() + calcGameScore(B, A, 0));
            } case DRAW -> {
                A.setScore(A.getScore() + calcGameScore(A, B, 0.5F));
                B.setScore(B.getScore() + calcGameScore(B, A, 0.5F));
            } case LOSE -> {
                A.setScore(A.getScore() + calcGameScore(A, B, 0));
                B.setScore(B.getScore() + calcGameScore(B, A, 1));
            }
        }
   }
}
