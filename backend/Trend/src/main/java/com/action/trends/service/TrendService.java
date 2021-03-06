package com.action.trends.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.action.trends.dto.Category;
import com.action.trends.dto.Trend;
import com.action.trends.dto.Twitter;

public interface TrendService {
	List<Category> readCategoryBySelfMade();

	Map<String, Object> readTrendByTrendId(int categoryId, int trendId);

	List<Trend> readBycategoryId(int categoryId);

	HashMap<String, Object> readNewsByTrendId(int trendId, int currentPage);

	List<Twitter> readTwitterByTrendId(int trendId); // HashMap<String, Object> int currentPage

	List<Map<String, Object>> readPredictedListByYearMonthWeek(int year, int month, int week);

	Map<String, Object> readPredictedByYearMonthWeekCategoryId(int year, int month, int week, int categoryId);

	List<HashMap<String, Object>> readAllTrendsNotSelfMade();
}
