package test;

import com.rank_calaculator.enums.Results;
import com.rank_calaculator.enums.Types;
import com.rank_calaculator.models.Game;
import com.rank_calaculator.models.Team;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @org.junit.jupiter.api.Test
    void calcGameResultCoeff() {
        Game game = new Game();

        // default case
        assertEquals(-1, game.calcGameResultCoeff());

        // Draw case
        game.setResult(Results.DRAW);
        assertEquals(0.5, game.calcGameResultCoeff());

        // Win case
        game.setResult(Results.WIN);
        assertEquals(1, game.calcGameResultCoeff());

        // Lose case
        game.setResult(Results.LOSE);
        assertEquals(0, game.calcGameResultCoeff());

    }

    @org.junit.jupiter.api.Test
    void calcGameTypeCoeff() {
        Game game = new Game();

        // Default
        assertEquals(-1, game.calcGameTypeCoeff());

        // Friendly out inter. calendar
        game.setType(Types.FRIENDLY_OUT_INTERNATIONAL_CALENDAR);
        assertEquals(5, game.calcGameTypeCoeff());

        // Friendly during inter. calendar
        game.setType(Types.FRIENDLY_DURING_INTERNATIONAL_CALENDAR);
        assertEquals(10, game.calcGameTypeCoeff());

        // Group phase of nations league
        game.setType(Types.GROUP_PHASE_OF_NATIONAL_LEAGUE);
        assertEquals(15, game.calcGameTypeCoeff());

        // Play-off and final off nations league
        game.setType(Types.PLAY_OFF_AND_FINAL_OF_NATIONAL_LEAGUE);
        assertEquals(25, game.calcGameTypeCoeff());

        // Qualification matches for confederations final competitions and world cup
        game.setType(Types.QUALIFICATION_MATCHES_FOR_CONFEDERATIONS_AND_WORLD_CUP);
        assertEquals(25, game.calcGameTypeCoeff());

        // Confederations final competition until QF stage
        game.setType(Types.CONFEDERATION_FINAL_UNTIL_QF_STAGES);
        assertEquals(35, game.calcGameTypeCoeff());

        // Confederations final competition from QF stage
        game.setType(Types.CONFEDERATION_FINAL_FROM_QF_STAGES);
        assertEquals(40, game.calcGameTypeCoeff());

        // World cup final competition until QF stage
        game.setType(Types.FIFA_WORLD_CUP_FINAL_UNTIL_QF_STAGES);
        assertEquals(50, game.calcGameTypeCoeff());

        // World cup final competition from QF stage
        game.setType(Types.FIFA_WORLD_CUP_FROM_QF_STAGES);
        assertEquals(60, game.calcGameTypeCoeff());


    }

    @org.junit.jupiter.api.Test
    void calcExpectedResult() {
        Game game = new Game();
        Team a = new Team();
        a.setScore(1300);
        Team b = new Team();
        b.setScore(1500);

        float expectedForA = 25 * (1 - game.calcExpectedResult(a, b));
        float expectedForB = 25 * (0 - game.calcExpectedResult(b, a));

        assertEquals(17.074649810791016, expectedForA);
        assertEquals(-17.074649810791016, expectedForB);
    }

    @org.junit.jupiter.api.Test
    void calcGameScore() {
        Game game = new Game();
        game.setType(Types.QUALIFICATION_MATCHES_FOR_CONFEDERATIONS_AND_WORLD_CUP);
        game.setResult(Results.DRAW);
        Team a = new Team();
        a.setScore(1500);
        Team b = new Team();
        b.setScore(1500);

        assertEquals(0, game.calcGameScore(a, b, 0.5F));
    }
}