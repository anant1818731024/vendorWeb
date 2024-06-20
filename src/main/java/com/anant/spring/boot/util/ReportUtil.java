package com.anant.spring.boot.util;

import java.util.List;

public interface ReportUtil {
	String generatePieChart(String path, List<Object[]> data);
}
