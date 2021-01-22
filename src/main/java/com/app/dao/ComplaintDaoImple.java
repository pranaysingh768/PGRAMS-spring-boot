package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.dto.ComplaintReport;
import com.app.dto.TotalComplaintBasedOnDate;
import com.app.dto.TotalComplaintBasedOnStatus;

@Repository
public class ComplaintDaoImple {
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public List<TotalComplaintBasedOnDate> complaintCountBasedOnDate() {
			
			String query = "select complaint_date,count(*) from complaint where user_complaint_status ='Approved' group by complaint_date";
			List<TotalComplaintBasedOnDate> totalComplaintBasedOnDate = jdbcTemplate.query(query,new RowMapper<TotalComplaintBasedOnDate>() {

				@Override
				public TotalComplaintBasedOnDate mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					TotalComplaintBasedOnDate totalComplaintBasedOnDate = new TotalComplaintBasedOnDate();
					totalComplaintBasedOnDate.setComplaintDate(rs.getString(1));
					totalComplaintBasedOnDate.setComplaintCount(rs.getInt(2));
					return totalComplaintBasedOnDate;
				}
				
			});
			return totalComplaintBasedOnDate;
		}
		
		public List<TotalComplaintBasedOnStatus> complaintCountBasedOnStatus(){
			
			String query = "select complaint_status,count(*) from complaint group by complaint_status";
			
			List<TotalComplaintBasedOnStatus> totalComplaintBasedOnStatus = jdbcTemplate.query(query, new RowMapper<TotalComplaintBasedOnStatus>() {

				@Override
				public TotalComplaintBasedOnStatus mapRow(ResultSet rs, int rowNum) throws SQLException {

					TotalComplaintBasedOnStatus totalComplaintBasedOnStatus = new TotalComplaintBasedOnStatus();
					totalComplaintBasedOnStatus.setComplaintStatus(rs.getString(1));
					totalComplaintBasedOnStatus.setComplaintCount(rs.getInt(2));
					return totalComplaintBasedOnStatus;
				}
			
			
			});
			
			return totalComplaintBasedOnStatus;
		}
		
		
		public List<ComplaintReport> allComplaintReport() {
			
			String str = "Approved";
			
			String query = "select complaint_type,complaint_title,complaint_detail,complaint_address,complaint_city,complaint_date,complaint_status,user_name,user_mail,user_phone_no from complaint left join user on employee_id=user.user_id where user_complaint_status='" + str +"'";
			List<ComplaintReport> complaintReport = jdbcTemplate.query(query,new RowMapper<ComplaintReport>() {

				@Override
				public ComplaintReport mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					ComplaintReport complaintReport = new ComplaintReport();
					complaintReport.setComplaintType(rs.getString(1));
					complaintReport.setComplaintTitle(rs.getString(2));
					complaintReport.setComplaintDetail(rs.getString(3));
					complaintReport.setComplaintAddress(rs.getString(4));
					complaintReport.setComplaintCity(rs.getString(5));
					complaintReport.setComplaintDate(rs.getString(6));
					complaintReport.setComplaintStatus(rs.getString(7));
					complaintReport.setUserName(rs.getString(8));
					complaintReport.setUserMail(rs.getString(9));
					complaintReport.setUserPhoneNo(rs.getString(10));
					//complaintReport.setComplaintDate(rs.getString(1));
					//ComplaintReport.setComplaintCount(rs.getInt(2));
					return complaintReport;
				}
				
			});
			return complaintReport;
		}
}
