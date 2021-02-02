package pattern.creational.builder;

/**
 * Patrón builder. Hace al código más legible, y evita usar constructures, que
 * puedan afectar a muchas clases cuando se le agregue un nuevo parametro.
 */
public class PersonBuilder {

    private String firstName;
    private String lastName;
    private String fechaNacimiento;
    private int edad;

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder fechaNacimiento(String fn) {
        this.fechaNacimiento = fn;
        return this;
    }

    public PersonBuilder edads(int edad) {
        this.edad = edad;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, fechaNacimiento, edad);
    }
}
