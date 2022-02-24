package com.hamsays;

import static org.junit.Assert.*;
import org.junit.Test;


public class BoardFactoryTest {
    private Board board;

    @Test
    public void createBoard_shouldCreateEasyBoard_whenCorrespondingDifficultyPassed(){
        board = BoardFactory.createBoard(Difficulty.EASY);
        assertEquals(board.getClass(), EasyBoard.class);
    }

    @Test
    public void createBoard_shouldCreateMediumBoard_whenCorrespondingDifficultyPassed(){
        board = BoardFactory.createBoard(Difficulty.MEDIUM);
        assertEquals(board.getClass(), MediumBoard.class);
    }

    @Test
    public void createBoard_shouldCreateHardBoard_whenCorrespondingDifficultyPassed(){
        board = BoardFactory.createBoard(Difficulty.HARD);
        assertEquals(board.getClass(), HardBoard.class);
    }

}