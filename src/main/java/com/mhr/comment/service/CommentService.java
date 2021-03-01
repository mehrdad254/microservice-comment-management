package com.mhr.comment.service;

import java.util.List;
import java.util.Optional;

import com.mhr.comment.model.Comment;

public interface CommentService {

	Comment saveOne(Comment comment);

	Optional<Comment> findOneComment(Long id);

	List<Comment> findAllComment();

	void deleteOneComment(Long id);

	void deleteAllComment();

}
