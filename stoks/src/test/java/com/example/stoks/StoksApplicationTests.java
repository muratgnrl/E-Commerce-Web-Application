package com.example.stoks;

import com.example.stoks.model.Category;
import com.example.stoks.repository.CategoryRepository;
import com.example.stoks.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StoksApplicationTests implements TestCrud {

	private final CategoryRepository categoryRepository;

	@Autowired
    StoksApplicationTests(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Test
	@Override
	public void testCreate(){
		Category category=Category
				.builder()
				.categoryName("Araç")
				.categoryDescription("Araba Markaları")
				.build();
		categoryRepository.save(category);
		assertNotNull(categoryRepository.findById(1L).get());


	}


	@Test
	@Override
	public void testUpdate() {

		Category category=categoryRepository.findById(1L).get();
		category.setCategoryName("Araba");
		categoryRepository.save(category);
		//Todo Eşit değilse bir sorun olmayacak,ama eşitse exception fırlatsın
		assertNotEquals("Araç",categoryRepository.findById(1L).get().getCategoryName());
	}

	@Test
	@Override
	public void testList(){


		List<Category> list=categoryRepository.findAll();

		//Todo Eğer sıfırdan büyükse liste vardır.
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Override
	public void testFindById() {

		Category category = categoryRepository.findById(1L).get();
		//Todo Araba Test adında birisi var mı yok mu.
		assertEquals("Araba", category.getCategoryName());

	}


	@Test
	@Override
	public void testDelete(){
		categoryRepository.deleteById(1L);
		//todo İsFalse  yapısı olarak karşımıza geliyo
		assertThat(categoryRepository.existsById(1L)).isFalse();

	}
}


