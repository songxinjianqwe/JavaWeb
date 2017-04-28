package me.newsong.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import me.newsong.domain.Area;
import me.newsong.domain.City;
import me.newsong.domain.Province;
import me.newsong.utils.JDBCUtils;

public class LocationDao {
	public List<Province> findAllProvinces() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from provinces";
		List<Province> list = runner.query(sql,new BeanListHandler<Province>(Province.class));
		return list;
	}
	
	public List<City> findByProvince(int provinceid) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from cities  where provinceid = ?";
		Object []params = {provinceid};
		List<City> list = runner.query(sql,new BeanListHandler<City>(City.class),params);
		return list;
	}
	
	public List<Area> findByCity(int cityid) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from areas where cityid = ?";
		Object []params = {cityid};
		List<Area> list = runner.query(sql,new BeanListHandler<Area>(Area.class),params);
		return list;
	}
}
