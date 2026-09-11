package br.com.kauan.controllers.service;

import br.com.kauan.exception.UnsupporterdMathOperationMethod;
import org.springframework.stereotype.Service;

@Service
public class ValidadeService {


    private boolean isNumeric(String strNumber) {

        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); //-> para resolver erros de double entre br us
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        //esse regex aceitas numeros positivos e neg de 0 a 9 e que possuem . como separadores e apos o separador,
        //vai de 0 a 9 tambem

    }

    public Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupporterdMathOperationMethod("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public void validadeNumber(String... numbers) {

        for (String number: numbers) {
            if (!isNumeric(number))
                throw new UnsupporterdMathOperationMethod("Please set a numeric value!");
        }
    }

}
