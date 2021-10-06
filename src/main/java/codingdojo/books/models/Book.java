package codingdojo.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")

public class Book {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min =5, max =200, message="Title must be at least 5 charachters.")
	private String title;
	
	@NotNull
	@Size(min = 5, max = 200, message="Description must be at least 5 charachters.")
	private String description;
	
	@NotNull
	@Size(min = 3, max =40, message="Lanugage name must be at least 3 charachters.")
	private String language;
	
	@NotNull
	@Min(value = 100, message= "Sorry, we would like preclude most of literature, including but not limited to poetry, novellas, short stories, and children's literature. The book must be at least 100 pages.")
	private Integer numberOfPages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Book() {

	}
	
	public Book(String title, String desc, String lang, int numPages) {
		this.title = title;
		this.description = desc;
		this.language = lang;
		this.numberOfPages = numPages;
	}
	
	public Book(Long id, String title, String desc, String lang, int numPages) {
		this.id = id;
		this.title = title;
		this.description = desc;
		this.language = lang;
		this.numberOfPages = numPages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
		
	}
}

	