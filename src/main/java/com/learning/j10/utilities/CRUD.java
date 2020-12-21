package com.learning.j10.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.jbbwebsolutions.utility.ServiceLocator;

public class CRUD {
	public final static Logger lgr = Logger.getLogger(SQLUtility.class.getName());
	
	public static <T> List<T> execute(String sql, String url, ESQL esql, SQLExecutable<T> executable, Object... objects)
			throws DataRepositoryCustomException {

		List<T> list = new ArrayList<T>();

		try (Connection con = esql == ESQL.CONNECTION ? DriverManager.getConnection(url)
				: ServiceLocator.getDataSource(url).getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {

			int i = 1;
			for (Object o : objects) {
				pst.setObject(i++, o);
			}

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				T t = executable.exec(resultSet);
				list.add(t);
			}

		} catch (Exception e) {
			lgr.log(Level.SEVERE, e.getMessage(), e);
			throw new DataRepositoryCustomException(e.getMessage());
		}
		return list;
	}
}
