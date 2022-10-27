package TriangleTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Triangle.BadSizeTriangleException;
import Triangle.Triangle;
import Triangle.InvalidTriangleException;


import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest{
    Logger logger = LoggerFactory.getLogger("TriangleTest");

    @Test
    @DisplayName("Тест 1: проверка расчета площади треугольника")
    void test1() throws InvalidTriangleException, BadSizeTriangleException {
        logger.info("Тест 1: проверка расчета площади треугольника");
        assertFalse(Triangle.getSquare(3,6,7)==0);
        logger.info("\tТест выполнен успешено");
    }

    @ParameterizedTest
    @CsvSource({"3,6,7,8.94427190999916","-3,-6,-7,8.94427190999916","3,-6,7,8.94427190999916","7,6,7,18.973665961010276"})
    @DisplayName("Тест 2: проверка корректности вычисления площади треугольников")
    void test2(int a, int b, int c, double d) throws InvalidTriangleException, BadSizeTriangleException {
        logger.info("Тест 2: проверка корректности вычисления площади треугольников");
        logger.info("\tВходящие параметры - (a,b,c) - " +a+", "+b+", "+c);
        assertEquals(Triangle.getSquare(a,b,c),d);
        logger.info("\tТест выполнен успешено");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/BadSizeTriangles.csv")
    @DisplayName("Test 3: сумма длин 2-х сторон треугольника равна длине третьей стороны")
    void test3(int a, int b, int c) throws InvalidTriangleException, BadSizeTriangleException {
        logger.info("Тест 3: сумма длин 2-х сторон треугольника равна длине третьей стороны");
        BadSizeTriangleException thrown = assertThrows(
                BadSizeTriangleException.class,
                ()->Triangle.getSquare(a, b, c));
        assertTrue(thrown.getMessage().contains("треугольник не имеет площади"));

        logger.info("\tТест выполнен успешено");
    }

    @Test
    @DisplayName("Тест 4: проверка срабатывания исключения")
    void test4() throws InvalidTriangleException, BadSizeTriangleException {
        logger.info("Тест 4: проверка срабатывания исключеният");
        assertThrows(InvalidTriangleException.class, ()->Triangle.getSquare(233, 6, 7));
        logger.info("\tТест выполнен успешено");
    }


}