package com.cg.bookStore.dao;

import java.util.List;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;

public interface ListBookInCategoryDao {

	public List<BookInformation> viewBooksInCategory(int categoryId) 
			throws InvalidCategoryIdException;

}
