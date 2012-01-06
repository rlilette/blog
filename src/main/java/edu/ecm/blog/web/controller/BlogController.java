package edu.ecm.blog.web.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ecm.blog.domain.Post;
import edu.ecm.blog.service.PostService;

@Controller
public class BlogController {

	@Inject
	private PostService postService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("posts", postService.find(0, 10));
		return "index";
	}

	@PostConstruct
    public void bootstrap() {
	   if (postService.count() != 0) {
		   return;  
		    }
	   else {
		   for (int i=1; i<6; i++){
		    	Post post = new Post();
		    	
			    post.setTitle("un post");
			    post.setSlug("un-post");
			    post.setDate(new Date());
			    post.setTags("tag 1, tag2");
			    post.setText("Il Žtait un petit navire, il Žtait un petit navire");
			    
			    
			    postService.save(post);
		   }
	   }

   }
	
	@RequestMapping("/billet/{slug}")
	public String post(@PathVariable String slug, Model model) {
	    model.addAttribute("post", postService.findBySlug(slug));

	    return "post";
	}
	
}
