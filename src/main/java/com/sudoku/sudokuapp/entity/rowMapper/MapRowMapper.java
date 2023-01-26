package com.sudoku.sudokuapp.entity.rowMapper;

import com.sudoku.sudokuapp.entity.Map;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRowMapper implements RowMapper<Map> {
    @Override
    public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Map(
                rs.getInt(1),
                rs.getString(2)
        );
    }
}
