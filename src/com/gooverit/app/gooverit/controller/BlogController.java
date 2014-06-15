package com.gooverit.app.gooverit.controller;

import com.gooverit.app.gooverit.entity.Blog;
import com.gooverit.app.gooverit.interceptor.BlogInterceptor;
import com.gooverit.app.gooverit.validator.BlogValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;


/**
 * @Project: gooverit
 * @Title: BlogController.java
 * @Package com.gooverit.app.gooverit.controller
 * @Description: BlogController.java
 * @author Turbo,Email:dailin2323@gmail.com
 * @date 2014年6月15日 下午11:25:46
 * @Copyright: 2014 
 * @version V1.0
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	public void index() {
		setAttr("blogPage", Blog.dao.paginate(getParaToInt(0, 1), 10));
		render("blog.html");
	}

	public void add() {
	}

	@Before(BlogValidator.class)
	public void save() {
		getModel(Blog.class).save();
		redirect("/blog");
	}

	public void edit() {
		setAttr("blog", Blog.dao.findById(getParaToInt()));
	}

	@Before(BlogValidator.class)
	public void update() {
		getModel(Blog.class).update();
		redirect("/blog");
	}

	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		redirect("/blog");
	}
}
