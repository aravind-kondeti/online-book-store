package com.cg.testcase.list;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.LDTConverter;
import com.cg.bookStore.service.ListBookInCategoryService;
import com.cg.bookStore.web.CategoryController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CategoryController.class)

	public class TestCases {
		
		@Autowired
		private MockMvc mockMvc;
		
		@MockBean
		private ListBookInCategoryService service;

	/*
	 * BookInformation info = new BookInformation(11, "Success", "Aravind",
	 * "this book is based on How to become successful", "ab12", LocalDate.of(1999,
	 * 03, 27), LocalDate.of(1999, 03, 27), 450 );
	 */

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void ViewBooksForCategoryId() throws Exception {

		/*
		 * Mockito.when( ListBookInCategoryService.(Mockito.anyString(),
		 * Mockito.anyString())).thenReturn(mockCourse);
		 */
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/viewcategory/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}

