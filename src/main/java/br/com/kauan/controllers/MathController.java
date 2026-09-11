package br.com.kauan.controllers;

import br.com.kauan.controllers.service.MathService;
import br.com.kauan.exception.UnsupporterdMathOperationMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/math")
public class MathController {

    MathService mathService = new MathService();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        return mathService.sub(numberOne, numberTwo);
    }

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        return mathService.multi(numberOne, numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws Exception {
        return mathService.div(numberOne, numberTwo);
    }

    @RequestMapping("/squareRoot/{numberOne}")
    public Double squareRoot(
            @PathVariable("numberOne") String numberOne

    ) throws Exception {
        return mathService.squareRoot(numberOne);
    }
}
