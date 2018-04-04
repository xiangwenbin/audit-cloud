package com.zhonghui.auditcloud.accounts.provider.controller.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.accounts.api.model.vo.Test;
import com.zhonghui.auditcloud.accounts.provider.controller.BaseController;
import com.zhonghui.core.model.vo.ResultVo;

import cn.hutool.core.util.ZipUtil;

@Controller
@RequestMapping("postgre")
public class PostgreCopyController extends BaseController {

//	@Autowired
//	private DataSource dataSource;
//
//	@RequestMapping(value = { "/copy" }, produces = "application/json")
//	@ResponseBody
//	public ResultVo<String> test() throws IOException, SQLException{
//		
//		return this.copy();
//	}
//	
//	@Transactional
//	private ResultVo<String> copy()  throws IOException, SQLException {
//		Connection connection = null;
//		BaseConnection baseConnection = null;
//		FileInputStream fileInputStream = null;
//		String sql = "copy acc_pkg_subject(acc_package_id,subject_id,parent_subject_id,subject_name,subject_fullname,assist_code,uom_unit,currency,is_leaf,level0,property) from STDIN with (delimiter E'\\x10',encoding 'utf8')";
//		try {
//			connection = dataSource.getConnection();
//			fileInputStream = new FileInputStream("c:/temp/c_AccPkgSubject_2_uft8.txt");
////			if (connection instanceof ConnectionHandle)
////				baseConnection= (BaseConnection)((ConnectionHandle) connection).
////			else
////				baseConnection = (BaseConnection) connection;
//			baseConnection = connection.unwrap(BaseConnection.class);
//			CopyManager cm = new CopyManager(baseConnection);
//			cm.copyIn(sql, fileInputStream);
////			connection.rollback();
////			throw new RuntimeException("xxx");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
////			if(!connection.isClosed())
////				connection.close();
////			if(!baseConnection.isClosed())
////				baseConnection.close();
//			fileInputStream.close();
//		}
//
//		return ResultVo.succ("");
//	}

}
