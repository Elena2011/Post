package telran.forum.service;

import java.util.List;

import telran.forum.dto.DatePeriodDto;
import telran.forum.dto.NewCommentDto;
import telran.forum.dto.NewPostDto;
import telran.forum.dto.PostUpdateDto;
import telran.post.domain.Post;

public interface IForumService {

	Post addNewPost(NewPostDto newPost);
	Post getPost(String id);
	Post removePost(String id);
	Post updatePost(PostUpdateDto updatePost);
	boolean addLike(String id);
	Post addComment(String id , NewCommentDto newComment);
	Iterable<Post> findByTags(List<String> tags);
	Iterable<Post> findByAuthor(String author);
	Iterable<Post> findByDate(DatePeriodDto period);
	
}
