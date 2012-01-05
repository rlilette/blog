package edu.ecm.blog.util;

import java.util.ArrayList;

public class TagCloud {

	private ArrayList<String> tags = new ArrayList<String>();
	
	public void add(String... tags) {
		if (tags == null){
			return;
		}
		
		for (String tag : tags) {
			if ((contains(tag) == false) && (tag != null) && (tag != "")){
			this.tags.add(tag);
			}
		}
	}

	public int size() {
		return this.tags.size();
	}
	
	public boolean contains(String test){
		return tags.contains(test);
	}
}
