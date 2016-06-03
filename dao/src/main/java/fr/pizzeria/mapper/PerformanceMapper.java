package fr.pizzeria.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.Performance;

public class PerformanceMapper implements RowMapper<Performance> {

	
		@Override
		public Performance mapRow(ResultSet rs, int rowNum) throws SQLException {
			Performance p = new Performance();
			p.setId(rs.getInt("id"));
			p.setService(rs.getString("service"));
			p.setDateMesure(rs.getDate("datemesure"));
			p.setExecutionTime(rs.getLong("executiontime"));
			return p;
		}
	
}
