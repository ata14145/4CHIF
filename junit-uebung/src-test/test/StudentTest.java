package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

import daten.GebDat;
import daten.Student;

public class StudentTest {
        private GregorianCalendar cal = new GregorianCalendar(1994,20,06);
        static Student s = new Student("Mohamed", "Ata", new GregorianCalendar(1994,20,06));
        static Student scopy = new Student("Nikolai", "Atanasoski", new GregorianCalendar(1994,31,04));
        static Student s2 = new Student("Michi", "Kaufmann", new GregorianCalendar(1993,11,15));
        static Student s3 = new Student("Prof", "Tschernko", new GregorianCalendar(2000,20,02));
        static TreeSet<Student> t = new TreeSet<Student>(new GebDat());
        
        @BeforeClass
        public static void setUp() throws Exception{
                t.add(s);
                t.add(scopy);
                t.add(s2);
                t.add(s3);
        }
        
        @Test
        public void WhenSortWorks(){
                assertSame(t.last(), s3);
                assertSame(t.first(),s2);
                Iterator iterator = t.iterator();
                while (iterator.hasNext())
                        System.out.print( iterator.next().toString() + ", " );
                System.out.println();
        }
        
        //COMPARETO TESTS
        @Test
        public void testIfCompareToWorks(){
                assertEquals(s.compareTo(scopy),0);
        }
        
        @Test
        public void WhenCompareToIsWrong(){
                assertEquals(s.compareTo(s2), 1);
        }
        
        
        
        //CONSTRUCTOR TESTS
        @Test
        public void constructorWithValidArguments() {
                assertSame("Mohamed", s.getFirstName());
                assertSame("Ata", s.getLastName());
                String s = s2.getStringBirthDate();
                assertTrue("19931115".equalsIgnoreCase(s));

                assertEquals("Mohamed", scopy.getFirstName());
                assertEquals("Ata", scopy.getLastName());
        }
        
        @Test
        public void constructorWithValidArgumentsFirstLastName(){
                Student st = new Student("Max", "Muster");
                assertSame("Max", st.getFirstName());
                assertSame("Muster", st.getLastName());
        }
        
        @Test
        public void IsEqualTrue(){
                assertTrue(s.isEqual(scopy));
        }
        
        @Test
        public void IsEqualFalse(){
                assertFalse(s.isEqual(s2));
        }
                          
        //Prüfen ob es null ist:
        
        @Test(expected = IllegalArgumentException.class)
        public void constructorWithNullArgumentForFirstName() {
                Student s = new Student(null, "Ata", cal);
        }
        @Test(expected = IllegalArgumentException.class)
        public void constructorWithNullArgumentForLastName() {
                Student s = new Student("Mohamed", null , cal);
        }
        @Test(expected = IllegalArgumentException.class)
        public void constructorWithNullArgumentForBirthDate() {
                Student s = new Student("Mohamed", "Ata", null);
        }
        
        //Prüfen ob der String leer ist:

        @Test(expected = IllegalArgumentException.class)
        public void constructorWithEmptyArgumentForFirstName() {
                Student s = new Student("", "Ata", cal);
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void constructorWithEmptyArgumentForLastName() {
                Student s = new Student("Mohamed", "", cal);
        }
        
        //TOSTRING TEST
        @Test
        public void testToString() {
                Student s = new Student("Mohamed", "Ata", cal);
                assertEquals("Student {firstName=Mohamed, lastName=Ata, birthDate=19942006}",
                                s.toString());
        }


}