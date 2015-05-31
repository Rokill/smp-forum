package ru.auquid.forum.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forum_leaf")
@NamedQueries({
		@NamedQuery(name = "Leaf.findAll", query = "SELECT a FROM Leaf a"),
		@NamedQuery(name = "Leaf.findById", query = "SELECT a FROM Leaf a WHERE a.id = :rootId"),
		@NamedQuery(name = "Leaf.findByRootId", query = "SELECT a FROM Leaf a WHERE a.upperLeafId = :rootId ORDER BY a.postTime DESC") })
public class Leaf implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="leaf_id_seq")
    @SequenceGenerator(name="leaf_id_seq", sequenceName="leaf_id_seq", allocationSize=1)
	@Column(name = "id", updatable = false)
	private Integer id;

	@Size(min = 1, max = 100)
	@Column(name = "username", columnDefinition = "bpchar")
	private String username;

	@Column(name = "postime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postTime;
	

	@Column(name = "msg", columnDefinition = "bpchar")
	private String msg;
	
	@Column(name = "is_last_leaf")
	private boolean isLastLeaf;

	@Column(name = "upper_leaf_id", nullable = true)
	private int upperLeafId;
	
	@Column(name = "rating")
	private int rating;

	public Leaf() {
		// TODO Auto-generated constructor stub
	}

	public Leaf(Integer id, String username, Date postTime, String msg,
			int upperLeafId, boolean isLastLeaf) {
		super();
		this.id = id;
		this.username = username;
		this.postTime = postTime;
		this.msg = msg;
		this.upperLeafId = upperLeafId;
		this.isLastLeaf = isLastLeaf;
	}

	public Leaf(User user, String msg, Leaf root) {
		this.username = user.getUsername();
		this.postTime = new Date();
		this.msg = msg;
		this.upperLeafId = root.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUpperLeafId() {
		return upperLeafId;
	}

	public void setUpperLeafId(int upperLeafId) {
		this.upperLeafId = upperLeafId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result
				+ ((postTime == null) ? 0 : postTime.hashCode());
		result = prime * result + upperLeafId;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leaf other = (Leaf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (postTime == null) {
			if (other.postTime != null)
				return false;
		} else if (!postTime.equals(other.postTime))
			return false;
		if (upperLeafId != other.upperLeafId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public boolean isLastLeaf() {
		return isLastLeaf;
	}

	public void setLastLeaf(boolean isLastleaf) {
		this.isLastLeaf = isLastleaf;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}



}
