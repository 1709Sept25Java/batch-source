package exercise.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="FLASHCARD")

@NamedQueries({ 
	@NamedQuery(
			name = "firstThreeFlashcardByStudent", 
			query = "from Flashcard f where f.student.id = :id"
			) 
	})

public class Flashcard implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1,name="flashcardSequence",sequenceName="SQ_FLASHCARD_PK")
	@Column(name="F_ID")
	private int id;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="ANSWER")
	private String answer;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="S_ID")
	private Student student;

	public Flashcard() {
		super();
	}

	public Flashcard(int id, String question, String answer, Student student) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", student=" + student + "]";
	}

	public Flashcard(String question, String answer, Student student) {
		super();
		this.question = question;
		this.answer = answer;
		this.student = student;
	}
	
	
	
}
