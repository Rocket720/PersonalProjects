
import java.util.ArrayList;

class Book{}
class Question1 {
    ArrayList<Book> bookList = new ArrayList<Book>();
    public Book nextBookToRead(){
        for (Book b : bookList) {
            if(b.isBestSeller())
                return b;
        }
        if(bookList.size()>0)
            return bookList.get(0);
        return null;
    }
    public ArrayList<Book> getBooksByAuthor(){
        ArrayList<Book> a = new ArrayList<Book>();
        if(nextBookToRead()==null)
            return null;
        a.add(nextBookToRead());
        for (Book b : bookList) {
            if(b.getAuthor().equals(a.get(0).getAuthor()))
                a.add(b);
        }
        return a;
    }
    public ArrayList<Book> getBooksBySubject(String subject){return null;}
    /*
    A private String data field called "subject" must be added to the Book class. 
    The Book constructors must be updated to modify the value of subject when an 
    instance of Book is initialized. A method with the heading "public String getSubject()" 
    must be added to the Book class in order to make the subject data accessible. 
    ReadingList would need a method with the header stated above. This method would 
    work similarly to getBooksByAuthor(), except it would require the user to input 
    a value for the subject parameter. The method would compare the subject parameter 
    to the subject datafield of each Book in bookList, and if they match, add them to 
    a new list which will be returned at the end of the loop.  
    */
}


class Question2{
    public static boolean getResponse(){
        return (int)(Math.random()*2)==0;
    }
    
    public static int numUntilObedient(int n){
        int count = 0;
        int tries = 0;
        while(count!=n){
            tries++;
            if (getResponse())
                count++;
            else
                count = 0;
        }
        return tries;
    }

    /*
    Firstly, numUntilObedient would have to be changed to return a boolean rather than an integer. 
    Next, an additional "int maxTries" parameter would have to be added to the parameters of numUntilObedient. 
    At this point the header should be "public static boolean numUntilObedient(int n, int maxTries)". 
    The method should run as written above but the final return statement that formerly said "return tries;" 
    should be modified to say "return tries <= maxTries". This way the boolean that is returned is controlled 
    by whether or not the tries taken was less than or equal to the maximum commands allowed. 
    If tries was greater than maxTries, the method returns false.
    */
    public static boolean numUntilObedient(int n, int maxTries){
        int count = 0;
        int tries = 0;
        while(count!=n){
            tries++;
            if (getResponse())
                count++;
            else
                count = 0;
        }
        return maxTries >= tries;
    }
}
