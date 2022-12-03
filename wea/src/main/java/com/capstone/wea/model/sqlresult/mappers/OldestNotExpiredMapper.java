package com.capstone.wea.model.sqlresult.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OldestNotExpiredMapper implements RowMapper<List<String>> {
    /**
     * Returns a list of strings that contains the cmac_message_number and cmac_cap_identifier
     * Index 0 contains the message number and index 1 contains the cap identifier
     *
     * @param rs the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return String list containing cmac_message_number and cmac_cap_identifier
     * @throws SQLException
     */
    @Override
    public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<String> result = new ArrayList<>();

        result.add(rs.getString("CMACMessageNumber"));
        result.add(rs.getString("CMACCapIdentifier"));

        return result;
    }
}
