package com.capgemini.gos.dao;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.gos.entity.RevenueTable;

public interface AdminRepository extends JpaRepository<RevenueTable, Integer> {
	@Query("select r from RevenueTable r where r.date1>=?1 and r.date1<=?2 and r.userid=?3 and r.productCategory=?4 order by date1")
	List<RevenueTable> viewSalesReportByUserAndCategory(Date entry, Date exit,String userid, String category);

	@Query("select r from RevenueTable r where r.date1>=?1 and r.date1<=?2 and r.productCategory=?3  order by r.date1")
	List<RevenueTable> viewDetailedSalesReportByProduct(Date entry, Date exit, String category);
}
