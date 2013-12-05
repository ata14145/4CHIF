import java.util.ArrayList;
import java.util.List;


public class StudentImplDAO implements StudentDAO{

	   List<Student> students;

	   public StudentImplDAO(){
	      students = new ArrayList<Student>();
	      Student student1 = new Student("Ata",14145);
	      Student student2 = new Student("Atanasoski",141444);
	      students.add(student1);
	      students.add(student2);		
	   }
	   @Override
	   public void deleteStudent(Student student) {
	      students.remove(student.getSchnr());
	      System.out.println("Schüler mit der Schülernummer: " + student.getSchnr() 
	         +", wurde gelöscht.");
	   }

	   @Override
	   public List<Student> getAllStudents() {
	      return students;
	   }

	   @Override
	   public Student getStudent(int rollNo) {
	      return students.get(rollNo);
	   }

	   @Override
	   public void updateStudent(Student student) {
	      students.get(student.getSchnr()).setName(student.getName());
	      System.out.println("Schüler mit der Schülernummer: " + student.getSchnr() 
	         +", wurde geupdatet");
	   }
}
