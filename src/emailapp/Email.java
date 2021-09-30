package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "nikecompany.com";

    //создаем конструктор который булет получат имя и фамилию
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //вызоваем метод с запросом отдела
        this.department = setDepartment();
        //вызов метода случайного пароля
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Твой пароль: " + this.password);
        //объеденяем элементы для почты
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }
    //обращаемся в department
    private String setDepartment(){
        System.out.println("Новый сотрудник " + firstName + ". Выберите номер департамента\n1 Продаж\n2 Маркетинга\n3 Бухгалтерия\n0 for none\nВведите номер: ");
        Scanner in = new Scanner(System.in);
        int depChois = in.nextInt();
        if(depChois == 1){ return "sales"; }
        else if(depChois == 2){ return "mark"; }
        else if(depChois == 3){ return "acct"; }
        else { return ""; }
    }
    //генерация случайного пароля
    private String randomPassword(int lehgth){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#$%&";
        char[] password = new char[lehgth];
        for (int i = 0; i < lehgth; i++) {
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //установить вместимость почтового ящика
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //создать альтернативный адрес почты
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //возможность смены пароля
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){ return password; }

    public String showInfo(){
        return "Фамилия Имя: " + firstName + " " + lastName +
                "\nEmail компании " + email +
                "\nОбъем email " + mailboxCapacity + "mb";
    }

}
