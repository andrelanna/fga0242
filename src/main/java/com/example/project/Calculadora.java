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

    public static boolean willAdditionOverflow(Short left, Short right) throws Exception {
        
        if ((right <  0) && right != Short.MIN_VALUE) {
            return willSubtractionOverflow(left,  (short) -right);
        } else {
            boolean res =  (short)((short)~(short)((short)left ^ (short)right) & (short)((short)left ^ (short)((short)left + (short)right))) < (short) 0;
            if(res) {
                throw new LimiteSuperiorExtrapoladoException();
            }
            return res;
        }
    }
    
    public static boolean willSubtractionOverflow(Short left, Short right) throws Exception{
        if(right == Short.MIN_VALUE && left > 0){
            throw new LimiteSuperiorExtrapoladoException();
        }
        if ((right <  0))  {
            return willAdditionOverflow(left,  (short) -right);
        } else {
            boolean res = (short)((short)((short)left ^ (short)right) & (short)((short)left ^ (short)((short)left - (short)right))) < (short) 0;
            if(res) {
                throw new LimiteInferiorExtrapoladoException();
            }
            return res;
        }
    }

    public static Short adicao(Short a, Short b) throws Exception {
        willAdditionOverflow(a, b);
        return (short) (a+b);

    }
    
    public static Short subtracao(Short a, Short b) throws Exception {
        willSubtractionOverflow(a, b);
        return  (short) (a-b);
    }

}
