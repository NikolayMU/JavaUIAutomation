package ru.gb.Triangle;


    public class BadSizeTriangleException extends Exception{
        public BadSizeTriangleException() {
            super("треугольник не имеет площади");
        }
    }

