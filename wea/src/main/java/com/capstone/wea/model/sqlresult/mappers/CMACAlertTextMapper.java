package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.cmac.CMACAlertAreaModel;
import com.capstone.wea.model.cmac.CMACAlertTextModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CMACAlertTextMapper implements RowMapper<CMACAlertTextModel> {
    @Override
    public CMACAlertTextModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CMACAlertTextModel text = new CMACAlertTextModel();

        text.setLanguage(rs.getString("Language"));
        text.setShortMessage(rs.getString("CMACShortMessage"));
        text.setLongMessage(rs.getString("CMACLongMessage"));

        return text;
    }
}
