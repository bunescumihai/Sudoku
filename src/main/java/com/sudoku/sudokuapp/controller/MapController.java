package com.sudoku.sudokuapp.controller;

import com.sudoku.sudokuapp.entity.Map;
import com.sudoku.sudokuapp.entity.ProgressedMap;
import com.sudoku.sudokuapp.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/map")
public class MapController {
    @Autowired
    private MapService mapService;

    @GetMapping
    public Map getMapById(@RequestParam int mapId){
        return mapService.getMapById(mapId);
    }
    @GetMapping("/rand")
    public Map getRandomMap(){
        return mapService.getRandomMap();
    }

    @PostMapping("/add-map")
    public void addNewMap(@RequestBody Map map){
        mapService.addNewMap(map);
    }

    @PostMapping("/save-map-progress")
    public void saveMapProgress(@RequestBody ProgressedMap progressedMap){
        this.mapService.saveMapProgress(progressedMap);
    }

    @GetMapping("/exists-map-progress")
    public boolean existsMapProgress(@RequestParam int userId, @RequestParam int mapId){
        return mapService.existsMapProgress(userId, mapId);
    }

    @PutMapping("/save-map-progress")
    public void rewriteMapProgress(@RequestBody ProgressedMap progressedMap){
        this.mapService.rewriteMapProgress(progressedMap);
    }

    @PostMapping("/save")
    public void save(@RequestParam int userId, @RequestParam int mapId){
        this.mapService.save(userId, mapId);
    }

    @GetMapping("/get-progressed-map")
    public String getProgressedMap(@RequestParam int userId, @RequestParam int mapId){
        return this.mapService.getProgressedMap(userId, mapId);
    }
}
