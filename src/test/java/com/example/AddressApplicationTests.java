package com.example;

import com.example.controllers.TblCityController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doThrow;


@SpringBootTest
class AddressApplicationTests {

	@Mock
	private TblCityController tblCityController;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testException(){
//		doThrow(HttpStatus.INTERNAL_SERVER_ERROR).when(searchController.searchByPostCode("sgsg"));
//	}


}
