package com.cg.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.ListBookInCategoryDao;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;
@Service
public class ListBookInCategoryServiceImpl implements ListBookInCategoryService{

	@Autowired
	public ListBookInCategoryDao dao;
	
	@Override
	public List<BookInformation> viewBooksForCategoryId(int categoryId) 
			throws InvalidCategoryIdException {
		List<BookInformation> booksList = dao.viewBooksInCategory(categoryId);
		if(booksList.isEmpty())
			throw new InvalidCategoryIdException("No books are available");
		
		return booksList;
	}

}
