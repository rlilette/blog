package edu.ecm.blog.util;

import junit.framework.Assert;

import org.junit.Test;

public class TagCloudTest {

	@Test
	public void add() {
		TagCloud tagCloud = new TagCloud();

		tagCloud.add("java");
	}

	@Test
	public void size() {
	   TagCloud tagCloud = new TagCloud();

	   tagCloud.add("java", "java", "python", "", null);

	   Assert.assertEquals(2, tagCloud.size());
	}

	@Test
	public void addMutiple() {
		TagCloud tagCloud = new TagCloud();

		tagCloud.add("java", "ruby", "python");
	}

	@Test
	public void addEmpty() {
		TagCloud tagCloud = new TagCloud();

		tagCloud.add();
	}

	@Test
	public void addNull() {
		TagCloud tagCloud = new TagCloud();

		tagCloud.add((String[]) null);
	}
	
	@Test
	public void contains() {
	   TagCloud tagCloud = new TagCloud();

	   tagCloud.add("java");

	   Assert.assertTrue(tagCloud.contains("java"));
	}

}
