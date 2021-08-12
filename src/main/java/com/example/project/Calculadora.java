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


public class Calculadora {

    public static boolean willAdditionOverflow(short left, short right) throws Exception {
        
        if ((right < (short) 0) && right != Short.MIN_VALUE) {
            return willSubtractionOverflow(left, (short) (- (short) right));
        } else {
            boolean res =  (short)((short)~(short)((short)left ^ (short)right) & (short)((short)left ^ (short)((short)left + (short)right))) < (short) 0;
            if(res) {
                throw new LimiteSuperiorExtrapoladoException();
            }
            return res;
        }
    }
    
    public static boolean willSubtractionOverflow(short left, short right) throws Exception{
        if (right < (short) 0) {
            // TODO convert right to a positive number ??
            return willAdditionOverflow(left, (short) (- (short) right));
        } else {
            boolean res = (short)((short)((short)left ^ (short)right) & (short)((short)left ^ (short)((short)left - (short)right))) < (short) 0;
            if(res) {
                throw new LimiteInferiorExtrapoladoException();
            }
            return res;
        }
    }

    public static short adicao(short a, short b) throws Exception {
        willAdditionOverflow(a, b);
        return (short) (a+b);

    }
    
    public static short subtracao(short a, short b) throws Exception {
        willSubtractionOverflow(a, b);
        System.out.println("subtracao: " + (a-b));
        return (short) (a-b);
    }

}
