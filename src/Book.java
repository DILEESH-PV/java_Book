import java.sql.*;
import java.util.Scanner;

public class Book
{
    public static void main(String[] args)
    {
        int Charge,choice;
        String Name, Author, cat,pb;


        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Select an option");
            System.out.println("1. Add a Book");
            System.out.println("2. view all Books");
            System.out.println("3. search a Book");
            System.out.println("4. update Book");
            System.out.println("5. Delete a Book");
            System.out.println("6.Exit");

            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add book selected");
                    System.out.println("Enter the book category");
                    cat=sc.next();
                    System.out.println("Enter the Book Name");
                    Name = sc.next();
                    System.out.println("Enter the Author Name ");
                    Author = sc.next();
                    System.out.println("Enter the publication ");
                    pb = sc.next();
                    System.out.println("Enter the Books charge per day");
                    Charge = sc.nextInt();
                    System.out.println("Book added....");
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root","");
                        String sql = "INSERT INTO `books`(`category`, `title`, `author`, `publication`, `price`) VALUES(?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,cat);
                        stmt.setString(2,Name);
                        stmt.setString(3,Author);
                        stmt.setString(4,pb);
                        stmt.setInt(5,Charge);
                        stmt.executeUpdate();

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("view all books selected");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql ="SELECT `category`, `title`, `author`, `publication`, `price` FROM `books`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String fetchBookName = rs.getString("title");
                            String fetchBookAuthor = rs.getString("author");
                            String fetchBookPub = rs.getString("publication");
                            String fetchBookCategory = rs.getString("category");
                            String fetchBookDayCharge = rs.getString("price");

                            System.out.println("Category     : "+fetchBookCategory);
                            System.out.println("Book Name    : "+fetchBookName);
                            System.out.println("Author       : "+fetchBookAuthor);
                            System.out.println("Publication  : "+fetchBookPub);
                            System.out.println("Books charge : "+fetchBookDayCharge+"\n");


                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 3:
                    System.out.println("search a book selected");
                    System.out.println("Enter Book Name ");
                    Name = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "SELECT `category`, `author`, `publication`, `price` FROM `books` WHERE `title`= '"+Name+"'";

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            //String fetchBookName = rs.getString("title");
                            String fetchBookAuthor = rs.getString("author");
                            String fetchBookPub = rs.getString("publication");
                            String fetchBookCategory = rs.getString("category");
                            String fetchBookDayCharge = rs.getString("price");

                            System.out.println("Category     : "+fetchBookCategory);
                            //System.out.println("Book Name    : "+fetchBookName);
                            System.out.println("Author       : "+fetchBookAuthor);
                            System.out.println("Publication  : "+fetchBookPub);
                            System.out.println("Books charge : "+fetchBookDayCharge+"\n");
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("update a book selected");
                    System.out.println("Enter book name ");
                    Name = sc.next();
                    System.out.println("Enter the Books Category to updated ");
                    cat = sc.next();
                    System.out.println("Enter the Author Name to updated ");
                    Author = sc.next();
                    System.out.println("Enter the publication to be updated ");
                    pb=sc.next();
                    System.out.println("Enter the Books charge per day to updated ");
                    Charge = sc.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "UPDATE `books` SET `category`='"+cat+"',`author`='"+Author+"',`publication`='"+pb+"',`price`='"+Charge+"' WHERE `title`='"+Name+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Data updated successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete a book selected");
                    System.out.println("Enter the book name ");
                    Name = sc.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "DELETE FROM `books` WHERE `title` = '" +Name+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Book deleted successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}