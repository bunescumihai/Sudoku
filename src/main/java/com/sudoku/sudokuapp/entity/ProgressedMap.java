package com.sudoku.sudokuapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProgressedMap {
    private int userId;
    private int mapId;
    private String mapRow;
}
