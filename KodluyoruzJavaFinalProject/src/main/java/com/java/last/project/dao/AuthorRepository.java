package com.java.last.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.last.project.model.Authors;

@Repository
public interface AuthorRepository extends CrudRepository<Authors, Integer> {

	@Query("Select a From Authors a Where a.authorID = :id") // id ye göre yazarı bulma
	public Authors findById(@Param("id") int id);

	// TODO : Yazar adına göre arama yapılacak

	@Query("Select auth From Authors auth where auth.authorName = :authorName ")
	public List<Authors> findByName(@Param("authorName") String authorString);

	@Query("Select auth From Authors auth") // tüm yazarları listeleme
	public List<Authors> listAllAuthor();
}
