package br.com.season.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.season.springproject.dao.UserDAO;
import br.com.season.springproject.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User findById(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	//As regras para gravação no banco devem ser feitas nessa classe. Ex: If == null.
	@Override
	public void save(User user) {
		userDAO.save(user);
	}

//	@Override
//	public User update(Integer userId, User user) {
//		User foundUser = findById(userId);
//		BeanUtils.copyProperties(user, foundUser, "id");
//		userDAO.update(foundUser);
//		return foundUser;
//	}
	
	@Override
	public User update(User user) {
		userDAO.update(user);
		return user;
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public User findByCpf(String cpf) {
		return userDAO.findByCpf(cpf);
	}


}
