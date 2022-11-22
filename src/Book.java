import java.util.Scanner;

public class Book
{
    public static void main(String[] args)
    {
        int choice;
        String name,des,pb,incr,cat;

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
                    System.out.println("Add author selected");


                    break;
                case 2:
                    System.out.println("view all authors selected");

                    break;
                case 3:
                    System.out.println("search a author selected");

                    break;
                case 4:
                    System.out.println("update author selected");
                    break;
                case 5:
                    System.out.println("Delete a author selected");

                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}