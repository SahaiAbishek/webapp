package com.example.demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
@Qualifier("userDao")
public class UserDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user) throws Exception{
		String sql = "INSERT INTO user (first_name, Last_name,file_name,file_data) VALUES ( ?, ?, ?, ?)";

		KeyHolder holder = new GeneratedKeyHolder();

		try {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getProvFirstName());
				ps.setString(2, user.getProvLastName());
				ps.setString(3, user.getMyfile().getOriginalFilename());
				try {
					ps.setBytes(4, user.getMyfile().getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return ps;
			}
		}, holder);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		Long userid = holder.getKey().longValue();
		// try {
		// jdbcTemplate.update("",
		// user.getProvFirstName(),
		// user.getProvLastName(),user.getMyfile().getOriginalFilename(),user.getMyfile().getBytes());
		// } catch (DataAccessException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		System.out.println("user added successfully" + userid);
	}

}
