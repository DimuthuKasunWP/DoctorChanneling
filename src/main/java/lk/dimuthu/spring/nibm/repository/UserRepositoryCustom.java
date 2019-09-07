package lk.dimuthu.spring.nibm.repository;

import lk.dimuthu.spring.nibm.domain.User;

/**
 * <p>UserRepositoryCustom interface.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */
public interface UserRepositoryCustom {

	/**
	 * Find an user with user's email and password
	 *
	 * @param email
	 *            to be found (aka username)
	 * @param password
	 *            password to be found
	 * @return {@link User}
	 */
	User findUserByEmailAndPassword(String email, String password);
}
