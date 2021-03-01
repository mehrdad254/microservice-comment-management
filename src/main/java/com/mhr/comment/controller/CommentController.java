package com.mhr.comment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhr.comment.model.Comment;
import com.mhr.comment.service.CommentService;

@CrossOrigin
@RequestMapping(value = "/comment")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Comment> saveOneComment(@RequestBody Comment comment){
		comment.setId((long) 0);
		return new ResponseEntity<Comment>(this.commentService.saveOne(comment),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Comment> updateOneComment(@RequestBody Comment comment){
		return new ResponseEntity<Comment>(this.commentService.saveOne(comment) , HttpStatus.OK);
	}
	
	@GetMapping(value = "shows")
	public ResponseEntity<List<Comment>> findAllComment(){
		return new ResponseEntity<List<Comment>>(this.commentService.findAllComment(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/{id}")
	public ResponseEntity<Optional<Comment>> findOneComment(@PathVariable("id") Long id){
		return new ResponseEntity<Optional<Comment>>(this.commentService.findOneComment(id),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteOneComment(@PathVariable("id") Long id){
		this.commentService.deleteOneComment(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	public ResponseEntity<?> deleteAllComment(){
		this.commentService.deleteAllComment();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
