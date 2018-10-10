package telran.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.forum.dto.DatePeriodDto;
import telran.forum.dto.NewCommentDto;
import telran.forum.dto.NewPostDto;
import telran.forum.dto.PostUpdateDto;
import telran.forum.service.IForumService;
import telran.post.domain.Post;

@RestController
public class ForumController {
	
	@Autowired
	IForumService forumservice;
	
	
	@PostMapping("/post")
	public Post addPost(@RequestBody NewPostDto newPost) {
		return forumservice.addNewPost(newPost);
	}
	
	@GetMapping("/post/{id}")
	public Post getPost(@PathVariable String id) {
		return forumservice.getPost(id);
	}
	
	@DeleteMapping("/post/{id}")
	public Post removePost(@PathVariable String id) {
		return forumservice.removePost(id);
	}
	
	@PutMapping("/post")
	public Post updatePost(@RequestBody PostUpdateDto updatePost) {
		return forumservice.updatePost(updatePost);
	}
	
	@PutMapping("/post/{id}/like")
	public boolean addLike(@PathVariable String id) {
		return forumservice.addLike(id);
	}
	
	@PutMapping("/post/{id}/comment")
	public Post addComment(@PathVariable String id , @RequestBody NewCommentDto newComment) {
		return forumservice.addComment(id, newComment);
	}
	
	@PostMapping("/posts/tags")
	public Iterable<Post> getPostByTags(@RequestBody List<String> tags){
		return forumservice.findByTags(tags);
	}
	
	@GetMapping("/posts/author/{author}")
	public Iterable<Post> getPostsByAuthor(@PathVariable String author){
		return forumservice.findByAuthor(author);
	}
	
	@PostMapping("/posts/period")
	public Iterable<Post> getPostsBetweenDate(@RequestBody DatePeriodDto periodDto){
		return forumservice.findByDate(periodDto);
	}

}
