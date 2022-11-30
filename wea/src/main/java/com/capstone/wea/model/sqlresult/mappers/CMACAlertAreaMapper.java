package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.cmac.CMACAlertAreaModel;
import com.capstone.wea.model.cmac.CMACMessageModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CMACAlertAreaMapper implements RowMapper<List<String>> {
    @Override
    public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<String> area = new ArrayList<>();

        area.add(rs.getString("AreaName"));
        area.add(rs.getString("CMASGeocode"));

        return area;
    }
}
