package com.sudoku.sudokuapp.repository.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sudoku.sudokuapp.entity.Map;
import com.sudoku.sudokuapp.entity.ProgressedMap;
import com.sudoku.sudokuapp.entity.rowMapper.MapRowMapper;
import com.sudoku.sudokuapp.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapRepositoryImpl implements MapRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map getMapById(int id) {
        String sql = "Select * from maps where map_id = ?";
        return jdbcTemplate.queryForObject(sql,new MapRowMapper(), id);
    }

    @Override
    public Integer getCountOfMaps() {
        String sql = "Select count(*) from maps";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void saveMapProgress(ProgressedMap progressedMap) {
        String sql = "Insert into saves values(?,?,?)";
        jdbcTemplate.update(sql, progressedMap.getUserId(), progressedMap.getMapId(), progressedMap.getMapRow());
    }

    @Override
    public boolean existsMapProgress(int userId, int mapId) {
        String sql = "Select count(*) from saves where user_id = ? and map_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId,mapId);
        return count != 0;
    }

    @Override
    public void rewriteMapProgress(ProgressedMap progressedMap) {
        String sql = "Update saves set map_row = ? where user_id = ? and map_id = ?";
        this.jdbcTemplate.update(sql, progressedMap.getMapRow(), progressedMap.getUserId(), progressedMap.getMapId());
    }

    @Override
    public boolean existsMapInSaves(int userId, int mapId) {
        String sql = "Select count(*) from saves where user_id = ? and map_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId,mapId);
        return count != 0;
    }

    @Override
    public void deleteMapFromSaves(int userId, int mapId){
        String sql = "Delete from saves where user_id = ? and map_id = ?";
        jdbcTemplate.update(sql, userId, mapId);
    }

    @Override
    public boolean alreadyExistsResolvedMap(int userId, int mapId) {
        String sql = "Select count(*) from resolved_maps where user_id = ? and map_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, mapId);
        return count != 0;
    }

    @Override
    public void addResolvedMap(int userId, int mapId) {
        String sql = "Insert into resolved_maps values(?,?)";
        jdbcTemplate.update(sql, userId, mapId);
    }

    @Override
    public String getProgressedMap(int userId, int mapId) {
        String sql = "Select (map_row) from saves where user_id = ? and map_id = ?";
        return this.jdbcTemplate.queryForObject(sql, String.class, userId,mapId);
    }

}
