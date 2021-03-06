package com.action.trends.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.trends.dto.Comment;
import com.action.trends.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository repository;

	@Override
	public List<HashMap<String, Object>> readByTrendId(int trendId) {
		List<HashMap<String, Object>> list = repository.readByTrendId(trendId);

		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).get("date") + "";
			temp = temp.replace('T', ' ');
			temp = temp.substring(0, temp.length() - 2);

			list.get(i).put("date", temp);
		}

		return list;
	}

	@Override
	public void insert(Comment comment) {
		if (repository.insert(comment) < 1) {
			throw new RuntimeException("트렌드 댓글 삽입 실패");
		}
	}

	@Override
	public void update(Comment comment) {
		if (repository.update(comment) < 1) {
			throw new RuntimeException("트렌드 댓글 수정 실패");
		}
	}

	@Override
	public void delete(int id) {
		if (repository.delete(id) < 1) {
			throw new RuntimeException("트렌드 댓글 삭제 실패");
		}
	}

}
