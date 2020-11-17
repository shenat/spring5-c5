package com.sat.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sat.bean.User;
import com.sat.data.interfaces.UserRepository;

//用户详情服务类 注意其实现了 security的UserDetailsService接口
@Service//必须有这个注解
public class UserRepositoryUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepo;
	
	//@Autowired  spring4.3后不需要了 可以看源码注释
	public UserRepositoryUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	//注意该类顶不能返回null
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		if(user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");
		
	}

}
