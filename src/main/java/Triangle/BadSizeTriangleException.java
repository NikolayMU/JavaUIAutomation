package Triangle;


    public class BadSizeTriangleException extends Exception{
        public BadSizeTriangleException() {
            super("треугольник не имеет площади");
        }
    }

