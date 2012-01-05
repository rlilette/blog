package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.ecm.blog.domain.Post;

public class PostServiceImpl implements PostService {

	@Inject
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#save(edu.ecm.blog.domain.Post)
	 */
	@Override
	@Transactional
	public void save(Post post) {
	    Session session = sessionFactory.getCurrentSession();

	    session.save(post);

	}

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(Long id) {

		Session session = sessionFactory.getCurrentSession();

		String hqldelete = "delete Post where id = :id";

		session.createQuery(hqldelete).setLong("id", id).executeUpdate();

	}

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#find(int, int)
	 */
	@Override
	@Transactional
	public List find(int pageIndex, int pageSize) {

		Session session = sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Post.class);

		crit.setFirstResult(pageIndex * pageSize);

		crit.setMaxResults(pageSize);

		List posts = crit.list();

		return posts;

	}

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#count()
	 */
	@Override
	@Transactional
	public int count() {

		Session session = sessionFactory.getCurrentSession();

		Long a = (Long) session.createQuery("select count(*) from Post")
				.uniqueResult();

		return a.intValue();
	}

}
