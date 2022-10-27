package ru.gb.Triangle;

public class InvalidTriangleException extends Exception{
    public InvalidTriangleException() {
        super("треугольник не существует");
    }
}