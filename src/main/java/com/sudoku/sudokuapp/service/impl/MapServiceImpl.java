package com.sudoku.sudokuapp.service.impl;

import com.sudoku.sudokuapp.entity.Map;
import com.sudoku.sudokuapp.entity.ProgressedMap;
import com.sudoku.sudokuapp.repository.MapRepository;
import com.sudoku.sudokuapp.service.MapService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapRepository mapRepository;

    @Override
    public Map getMapById(int id) {
        return mapRepository.getMapById(id);
    }

    @Override
    public Map getRandomMap() {
        Random random = new Random();
        Integer countOfMaps = mapRepository.getCountOfMaps();
        int id = random.nextInt(countOfMaps)+1;
        return getMapById(id);
    }

    @Override
    public void saveMapProgress(ProgressedMap progressedMap) {
        if( existsMapProgress(progressedMap.getUserId(), progressedMap.getMapId()))
            rewriteMapProgress(progressedMap);
        else if(!this.mapRepository.alreadyExistsResolvedMap(progressedMap.getUserId(), progressedMap.getMapId()))
            this.mapRepository.saveMapProgress(progressedMap);
    }

    @Override
    public boolean existsMapProgress(int userId, int mapId) {
        return mapRepository.existsMapProgress(userId, mapId);
    }

    @Override
    public void rewriteMapProgress(ProgressedMap progressedMap) {
        this.mapRepository.rewriteMapProgress(progressedMap);
    }

    @Override
    public void save(int userId, int mapId) {
        if(this.mapRepository.existsMapInSaves(userId,mapId)){
            this.mapRepository.deleteMapFromSaves(userId,mapId);
        }
        if(!this.mapRepository.alreadyExistsResolvedMap(userId, mapId))
            this.mapRepository.addResolvedMap(userId, mapId);
    }

    @Override
    public void addNewMap(Map map) {

    }

    @Override
    public String getProgressedMap(int userId, int mapId) {
        if(!mapRepository.existsMapInSaves(userId,mapId))
            return null;
        JSONObject json = new JSONObject();
        json.put("mapRow", this.mapRepository.getProgressedMap(userId,mapId));
        return json.toString();
    }


}
