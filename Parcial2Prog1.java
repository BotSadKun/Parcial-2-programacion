/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figurasGeometricas;
import java.util.Scanner;

public class Parcial2Prog1 {


        public enum TipoFigura {
        CUADRADO,
        CIRCULO,
        RECTANGULO,
        TRIANGULO,
        ROMBO,
        TRAPECIO
    }


        public static void main(String[] args) {
        System.out.println("Ingrese el tipo de figura");
        System.out.println("1. Cuadrado");
        System.out.println("2. Círculo");
        System.out.println("3. Rectángulo");
        System.out.println("4. Triángulo");
        System.out.println("5. Rombo");
        System.out.println("6. Trapecio");
        System.out.println("7. Salir");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        FiguraGeometrica figura = null;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la longitud de un lado del cuadrado(cm):");
                double ladoCuadrado = scanner.nextDouble();
                figura = new Cuadrado(ladoCuadrado);
                break;
            case 2:
                System.out.println("Ingrese el radio del círculo(cm²):");
                double radio = scanner.nextDouble();
                figura = new Circulo(radio);
                break;
            case 3:
                System.out.println("Ingrese la base del rectángulo(cm):");
                double baseRectangulo = scanner.nextDouble();
                System.out.println("Ingrese la altura del rectángulo(cm):");
                double alturaRectangulo = scanner.nextDouble();
                figura = new Rectangulo(baseRectangulo, alturaRectangulo);
                break;
            case 4:
            break;
            case 5:
                System.out.println("Ingrese la longitud de la diagonal mayor del rombo(cm):");
                double diagonalMayor = scanner.nextDouble();
                System.out.println("Ingrese la longitud de la diagonal menor del rombo(cm):");
                double diagonalMenor = scanner.nextDouble();
                figura = new Rombo(diagonalMayor, diagonalMenor);
                break;
            case 6:
                System.out.println("Ingrese la longitud de la b4ase mayor del trapecio(cm):");
                double baseMayor = scanner.nextDouble();
                System.out.println("Ingrese la longitud de la base menor del trapecio(cm):");
                double baseMenor = scanner.nextDouble();
                System.out.println("Ingrese la altura del trapecio(cm):");
                double alturaTrapecio = scanner.nextDouble();
                figura = new Trapecio(baseMayor, baseMenor, alturaTrapecio);
                break;
            case 7:
                System.out.println("Saliendo...");
                scanner.close();
                return;
            default:
                System.out.println("Opción no válida.");
                scanner.close();
                return;
        }
        if(opcion == 4){
            System.out.println("Ingrese la longitud del lado 1 del triángulo (cm):");
        double lado1 = scanner.nextDouble();

        System.out.println("Ingrese la longitud del lado 2 del triángulo (cm):");
        double lado2 = scanner.nextDouble();
        
        TrianguloRectangulo triangulo = new TrianguloRectangulo();
        
        double hipotenusa = triangulo.calcularHipotenusa(lado1, lado2);
        double area = triangulo.calcularArea(lado1, lado2);
        double perimetro = triangulo.calcularPerimetro(lado1, lado2);
        String clasificacion = triangulo.clasificarTriangulo(lado1, lado2);
        
        System.out.println("Hipotenusa: " + hipotenusa + " cm");
        System.out.println("Área: " + area + " cm^2");
        System.out.println("Perímetro: " + perimetro + " cm");
        System.out.println("Clasificación: " + clasificacion);
        scanner.close();
        }

        ImpresoraFigura.imprimirFigura(figura);

        scanner.close();
    }
}

class ImpresoraFigura {
    public static void imprimirFigura(FiguraGeometrica figura) {
        if (figura instanceof Cuadrado) {
            Cuadrado cuadrado = (Cuadrado) figura;
            System.out.println("Cuadrado");
            System.out.println("Lado: " + cuadrado.getLado());
            System.out.println("Área: " + cuadrado.calcularArea());
            System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
        } else if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            System.out.println("Círculo");
            System.out.println("Radio en cm: " + circulo.getRadio());
            System.out.println("Área: " + circulo.calcularArea() + " cm");
            System.out.println("Perímetro: " + circulo.calcularPerimetro() + " cm");
        } else if (figura instanceof Rectangulo) {
            Rectangulo rectangulo = (Rectangulo) figura;
            System.out.println("Rectángulo");
            System.out.println("Base: " + rectangulo.getBase());
            System.out.println("Altura: " + rectangulo.getAltura());
            System.out.println("Área: " + rectangulo.calcularArea());
            System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
        } else if (figura instanceof Rombo) {
            Rombo rombo = (Rombo) figura;
            System.out.println("Rombo");
            System.out.println("Diagonal Mayor: " + rombo.getDiagonalMayor());
            System.out.println("Diagonal Menor: " + rombo.getDiagonalMenor());
            System.out.println("Área: " + rombo.calcularArea());
            System.out.println("Perímetro: " + rombo.calcularPerimetro());
        } else if (figura instanceof Trapecio) {
            Trapecio trapecio = (Trapecio) figura;
            System.out.println("Trapecio");
            System.out.println("Base Mayor: " + trapecio.getBaseMayor());
            System.out.println("Base Menor: " + trapecio.getBaseMenor());
            System.out.println("Altura: " + trapecio.getAltura());
            System.out.println("Área: " + trapecio.calcularArea());
            System.out.println("Perímetro: " + trapecio.calcularPerimetro());
        }
    }
}


abstract class FiguraGeometrica {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}

class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

    class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class Rombo extends FiguraGeometrica {
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    @Override
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * Math.sqrt((diagonalMayor * diagonalMayor + diagonalMenor * diagonalMenor) / 4);
    }
    
    
}

class Trapecio extends FiguraGeometrica {
    private double baseMayor;
    private double baseMenor;
    private double altura;

    public Trapecio(double baseMayor, double baseMenor, double altura) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    public double getBaseMayor() {
        return baseMayor;
    }

    public double getBaseMenor() {
        return baseMenor;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return ((baseMayor + baseMenor) * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        double ladoA = Math.abs((baseMayor - baseMenor) / 2);
        double ladoB = Math.sqrt(ladoA * ladoA + altura * altura);
        return 2 * (baseMayor + baseMenor) + ladoA + ladoB;
    }

}

class TrianguloRectangulo {

    public double calcularHipotenusa(double lado1, double lado2) {
        return Math.sqrt(Math.pow(lado1, 2) + Math.pow(lado2, 2));
    }

    public double calcularArea(double lado1, double lado2) {
        return (lado1 * lado2) / 2;
    }

    public double calcularPerimetro(double lado1, double lado2) {
        double hipotenusa = calcularHipotenusa(lado1, lado2);
        return lado1 + lado2 + hipotenusa;
    }

    public String clasificarTriangulo(double lado1, double lado2) {
        double hipotenusa = calcularHipotenusa(lado1, lado2);

        if (lado1 == lado2 && lado1 != hipotenusa) {
            return "Isósceles";
        } else if (lado1 != lado2 && lado1 != hipotenusa && lado2 != hipotenusa) {
            return "Escaleno";
        } else if (lado1 == lado2 && lado1 == hipotenusa) {
            return "Equilátero";
        } else {
            return "Triángulo rectángulo pero no cumple las condiciones para ser isósceles, escaleno o equilátero.";
        }
    }
}
