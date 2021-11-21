/**
 * Java 1 Homevork 5
 *
 * Author Ivan Gurenkov
 * @version 21.11.2021
 */

class Employee {
    
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;


    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        }

    
    @Override
    public String toString(){
            return String.format("name: %s \t Position: %s \nEmail: %s \t Phone: %s \n Salary: %d \t Age: %d \n",
                    name, position, email, phone, salary, age);}

    
    public void print(){
        System.out.println(this);
        }


    public static void main(String[] args)  {

        Employee[] persArray = new Employee[5];
                persArray[0] = new Employee("Vladimir Petrov", "DG", "Petr@gmail.com", "+79237564091", 200000, 48);
                persArray[1] = new Employee("Ivan Samsonov", "Manager", "SAmson@gmail.com", "+79314538447", 125000, 41);
                persArray[2] = new Employee("Vladislav Medvedev", "Security", "MedveD@gmail.com", "+79945003219", 66000, 36);
                persArray[3] = new Employee("Elena Koshkina", "QA manager", "Catwoman@gmail.com", "+79236673201", 100000, 23);
                persArray[4] = new Employee("Olga Krasnova", "Manager", "oKras@gmail.com", "+79254985671", 133000, 45);

        
        for (int i=0; i < persArray.length; i++)
        if (persArray[i].age > 40) persArray[i].print();

    }
}