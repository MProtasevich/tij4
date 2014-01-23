package generics.ex31;


//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)
interface Payable {
}


class Employee implements Payable {
}


class Hourly extends Employee implements Payable {
} // /:~