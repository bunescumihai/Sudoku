package com.sudoku.sudokuapp.service;

import com.sudoku.sudokuapp.entity.Map;
import com.sudoku.sudokuapp.entity.ProgressedMap;
import org.json.JSONObject;

public interface MapService {

    Map getMapById(int id);

    Map getRandomMap();

    void saveMapProgress(ProgressedMap progressedMap);

    boolean existsMapProgress(int userId, int mapId);

    void rewriteMapProgress(ProgressedMap progressedMap);

    void save(int userId, int mapId);

    void addNewMap(Map map);

    String getProgressedMap(int userId, int mapId);
}
