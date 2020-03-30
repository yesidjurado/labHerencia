package labherencia;

import javax.swing.JOptionPane;

public class Estudiante extends Persona{
    
    private String carnet;
    private double promedioNotas;
    private int numeroMaterias;
    
    public Estudiante(){
        
    }
    public Estudiante (String nombre, String apellido, int edad, int peso, String carnet, double promedioNotas, int numeroMaterias){
    //Usamos el operador super para establecer el constructor
    //de la superclase
    super(nombre, apellido, edad, peso);
    //Definimos los atributos propios de este objeto que hereda
        this.carnet = carnet;
        this.promedioNotas = promedioNotas;
        this.numeroMaterias = numeroMaterias;
    }
    //Métodos de encapsulamiento

    public String getCarnet() {
        return carnet;
    }

    public double getPromedioNotas() {
        return promedioNotas;
    }

    public int getNumeroMaterias() {
        return numeroMaterias;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public void setNumeroMaterias(int numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }
    
    //Método para calcular el promedio del estudiante
    public double calcularPromedio(int numeroMaterias) {
        double suma;
        suma = leerNotasEstudiante(numeroMaterias);
        promedioNotas = suma/numeroMaterias;
        return (promedioNotas);
        
    }
    //Método para leer las notas del estudiante
    public int leerNotasEstudiante(int numeroMaterias){
        int notas, suma = 0;
        for (int i = 0; i < numeroMaterias; i++) {
            
            notas = leerDatoTipoEntero("Ingrese la nota "+(i+1)+":");
            
            suma += notas;
        }
        return (suma);
    }
    //Método para ingresar los datos del estudiante
    public Estudiante ingresarDatosEstudiante(){
        Estudiante nuevoEstudiante = new Estudiante();
        String nombre = "";
        String apellido = "";
        int edad = 0;
        double peso = 0.0;
        String carnet = "";
        double promedioNotas = 0.0;
        int numeroMaterias = 0;
        carnet = leerDatoTipoCadena("Ingrese el código del carnet del estudiante: ");
        nombre = leerDatoTipoCadena("Ingrese el nombre del estudiante: ");
        apellido = leerDatoTipoCadena("Ingrese el apellido del estudiante: ");
        edad = leerDatoTipoEntero("Ingrese la edad del estudiante: ");
        peso = leerDatoTipoReal("Ingrese el peso del estudiante: ");
        
        numeroMaterias = leerDatoTipoEntero("Ingrese el número de materias: ");
        
        promedioNotas = calcularPromedio(numeroMaterias);
        
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setApellido(apellido);
        nuevoEstudiante.setCarnet(carnet);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setPeso(peso);
        nuevoEstudiante.setNumeroMaterias(numeroMaterias);
        nuevoEstudiante.setPromedioNotas(promedioNotas);
        
        return (nuevoEstudiante);
        
    }
    //Método para imprimir los datos y el promedio del estudiante
    public void imprimirReporteNotasEstudiante() {
        imprimirDatosPersona();
        JOptionPane.showMessageDialog(null,"El código del carnet del estudiante es: "+ carnet+"\nEl número de  materias del estudiante es: "+numeroMaterias+"\nEl promedio de las notas del estudiante es: "+ promedioNotas);
    }
    
    //Método sobreescrito para definir el estado del estudiante
     @Override
    public void definirEstadoPersona (int edad){
        String estado = "";
        if (edad < 21){
        estado = "Menor de edad legal";
        }else{
        estado = "Mayor de edad legal";
        }
        JOptionPane.showMessageDialog(null,"La persona " + nombre + "" + apellido + " es " + estado);
    }
}
