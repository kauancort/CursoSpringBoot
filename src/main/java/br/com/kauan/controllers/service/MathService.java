package br.com.kauan.controllers.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    ValidadeService validade = new ValidadeService();


    public Double sum(String numberOne, String numberTwo) {
        validade.validadeNumber(numberOne, numberTwo);
        return validade.convertToDouble(numberOne) + validade.convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo) {
        validade.validadeNumber(numberOne, numberTwo);
        return validade.convertToDouble(numberOne) - validade.convertToDouble(numberTwo);
    }

    public Double multi(String numberOne, String numberTwo) {
        validade.validadeNumber(numberOne, numberTwo);
        return validade.convertToDouble(numberOne) * validade.convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo) {
        validade.validadeNumber(numberOne, numberTwo);
        return validade.convertToDouble(numberOne) / validade.convertToDouble(numberTwo);
    }

    public Double squareRoot(String numberOne) {
        validade.validadeNumber(numberOne);
        return Math.sqrt(validade.convertToDouble(numberOne));
    }
}
