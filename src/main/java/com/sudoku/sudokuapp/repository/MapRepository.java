package com.sudoku.sudokuapp.repository;

import com.sudoku.sudokuapp.entity.Map;
import com.sudoku.sudokuapp.entity.ProgressedMap;

public interface MapRepository {
    Map getMapById(int id);

    Integer getCountOfMaps();

    void saveMapProgress(ProgressedMap progressedMap);

    boolean existsMapProgress(int userId, int mapId);

    void rewriteMapProgress(ProgressedMap progressedMap);

    boolean existsMapInSaves(int userId, int mapId);

    void deleteMapFromSaves(int userId, int mapId);

    boolean alreadyExistsResolvedMap(int userId, int mapId);

    void addResolvedMap(int userId, int mapId);

    String getProgressedMap(int userId, int mapId);
}
