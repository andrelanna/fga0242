/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTests {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3,    2,   5",
            "-3,    -2,   -5",
            "3,  0, 3",
            "-3,  0, -3",
            "0,   0,   0",
            "-32768, 0, -32768",
            "-32768,  1, -32767",
            "32767, -1, 32766",
            "32767, 0, 32767"
    })
    void adiciona(short first, short second, short expectedResult) throws Exception {
        Calculadora calculator = new Calculadora();
        assertEquals(expectedResult, calculator.adicao(first, second),
                () -> first + " + " + second + " deve ser igual a " + expectedResult);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "3,	2,	1",
            "2,	3,	-1",
            "-3,	-2,	-1",
            "-2,	-3,	1",
            "3,	0,	3",
            "0,	3,	-3",
            "-3,	0,	-3",
            "0,	3,	-3",
            "0,	0,	0"
    })
    void subtrai(short first, short second, short expectedResult) throws Exception {
        Calculadora calculator = new Calculadora();
        assertEquals(expectedResult, calculator.subtracao(first, second),
                () -> first + " - " + second + " deve ser igual a " + expectedResult);
    }

    @ParameterizedTest(name = "{0} + {1} => extrapolaSuperior")
    @CsvSource({
            "32767,    1",
            "32767,    2"
    })
    void adicionaExtrapolaSup(short first, short second) {
        Calculadora calculator = new Calculadora();
        assertThrows(LimiteSuperiorExtrapoladoException.class, () -> calculator.adicao(first, second));
    }

    @ParameterizedTest(name = "{0} + {1} => extrapolaInferior")
    @CsvSource({
            "-32768,    -1",
            "-32768,    -2"
    })
    void adicionaExtrapolaInf(short first, short second) {
        Calculadora calculator = new Calculadora();
        assertThrows(LimiteInferiorExtrapoladoException.class, () -> calculator.adicao(first, second));
    }

    @ParameterizedTest(name = "{0} - {1} => extrapolaInferior")
    @CsvSource({
            "-32768,    1",
    })
    void subtraiExtrapolaInf(short first, short second) {
        Calculadora calculator = new Calculadora();
        assertThrows(LimiteInferiorExtrapoladoException.class, () -> calculator.subtracao(first, second));
    }

    @ParameterizedTest(name = "{0} - {1} => extrapolaSuperior")
    @CsvSource({
            "1,    -32768"
    })
    void subtraiExtrapolaSup(short first, short second) {
        Calculadora calculator = new Calculadora();
        assertThrows(LimiteSuperiorExtrapoladoException.class, () -> calculator.subtracao(first, second));
    }
}

