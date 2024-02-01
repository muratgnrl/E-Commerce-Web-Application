package com.example.auth;

import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthApplicationTests implements TestCrud {

	private final UserRepository userRepository;

	@Autowired
    AuthApplicationTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Test
	@Override
	public void testCreate(){
		User user=User
				.builder()
				.firstName("Kerem")
				.lastName("Soyturk")
				.mail("keremsoyturk@gmail.com")
				.password("12345")
				.build();
		userRepository.save(user);

		assertNotNull(userRepository.findById(1L).get());
		//Todo nesne null ise assertionError hatası göndersin  1L birinci kayda göre verileri getir
	}


	@Test
	@Override
	public void testUpdate() {

		User user=userRepository.findById(1L).get();
		user.setLastName("Aracı");
		userRepository.save(user);
		//Todo Eşit değilse bir sorun olmayacak,ama eşitse exception fırlatsın
		assertNotEquals("Soyturk",userRepository.findById(1L).get().getLastName());
	}

	@Test
	@Override
	public void testList(){


		List<User> list=userRepository.findAll();

		//Todo Eğer sıfırdan büyükse liste vardır.
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Override
	public void testFindById() {

		User user = userRepository.findById(1L).get();
		//Todo Kerem Test adında birisi var mı yok mu.
		assertEquals("Kerem", user.getFirstName());

	}
	@Test
	@Override
	public void testLogin(){


		User userlogin= userRepository.findUserByMailAndPassword("keremsoyturk@gmail.com", "12345");

		assertNotNull(userlogin);
		assertEquals("Kerem", userlogin.getFirstName());
		assertEquals("Aracı", userlogin.getLastName());
	}


	@Test
	@Override
	public void testDelete(){
		userRepository.deleteById(1L);
		//todo İsFalse  yapısı olarak karşımıza geliyo
		assertThat(userRepository.existsById(1L)).isFalse();


	}
}
