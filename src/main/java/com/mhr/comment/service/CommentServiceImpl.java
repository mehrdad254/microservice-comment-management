package com.mhr.comment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhr.comment.date.PersianDateTime;
import com.mhr.comment.model.Comment;
import com.mhr.comment.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public Comment saveOne(Comment comment) {
		
		PersianDateTime Date = new PersianDateTime();
		
		comment.setCreateDateAt(Date.webDate());
		comment.setCreateTimeAt(Date.webTime());
		comment.setUpdateDateAt(Date.webDate());
		comment.setUpdateTimeAt(Date.webTime());
		
		return this.commentRepository.save(comment);
	}
	
	@Override
	public Optional<Comment> findOneComment(Long id) {
		return this.commentRepository.findById(id);
	}
	
	@Override
	public List<Comment> findAllComment(){
		return this.commentRepository.findAll();
	}
	
	@Override
	public void deleteOneComment(Long id) {
		this.commentRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllComment() {
		this.commentRepository.deleteAll();
	}
}
