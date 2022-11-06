package com.medicalstore.medicalstore.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.medicalstore.medicalstore.models.users;

public class RowMapperImpl implements RowMapper<users>{

    @Override
    @Nullable
    public users mapRow(ResultSet rs, int rowNum) throws SQLException {
        users user = new users();
        user.setUser_id(rs.getInt(1));
        user.setUsername(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setRole(rs.getString(4));
        user.setEnabled(rs.getInt(5));
        user.setEmail(rs.getString(6));
        return user;
    }

    
}
