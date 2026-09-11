package br.com.kauan.controllers;

import br.com.kauan.exception.UnsupporterdMathOperationMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/math")
public class MathController {

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupporterdMathOperationMethod("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {

        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); //-> para resolver erros de double entre br us
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
            //esse regex aceitas numeros positivos e neg de 0 a 9 e que possuem . como separadores e apos o separador,
                //vai de 0 a 9 tambem

    }
    //realizando calculos por meio de path params;
    //exemplos:

    //http://localhost:8080/math/sum/3/5

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupporterdMathOperationMethod("Please set a numeric value!");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/sub/3/5

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupporterdMathOperationMethod("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/multi/3/5

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupporterdMathOperationMethod("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/div/3/5

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupporterdMathOperationMethod("Please set a numeric value");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    
}
