package ua.lviv.lgs.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="comment")
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
	private Integer id;

@Column
	private String authorName;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="post_id_FK", nullable=false)
	private Post post;

	public Comment() {
	}
	
	public Comment(String authorName, Post post) {
		this.authorName = authorName;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(authorName, other.authorName) && id == other.id;
	}

	@Override
	public String toString() {
		return "\nComment [id=" + id + ", authorName=" + authorName + "";
	}

}
