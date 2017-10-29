package exercise.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="studentSequence")
	@SequenceGenerator(allocationSize=1,name="studentSequence",sequenceName="SQ_STUDENT_PK")
	@Column(name="S_ID")
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Flashcard> flashcards;
	
	public Student() {
		super();
	}

	public Student(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public Student(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	
	
}
