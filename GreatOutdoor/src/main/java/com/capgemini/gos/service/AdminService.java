package com.capgemini.gos.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.gos.entity.GrowthReport;
import com.capgemini.gos.entity.RevenueTable;

public interface AdminService {
	
	List<GrowthReport> viewDetailedSalesReportByProduct(Date entry,Date exit,String category);
	List<RevenueTable> viewSalesReportByUserAndCategory(Date entry,Date exit,String targetUserId,String category);


}
