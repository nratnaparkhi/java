package com.example.demo.controller;

import java.math.BigInteger;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Output;
import com.example.demo.OutputBig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")

@Api(value="Demo", description="Operations pertaining to products in Online Store")
public class DemoController implements ErrorController {

	@ApiOperation(value="Add two integers")
	
	@GetMapping(path="/add/{a}/{b}", produces="application/json")
	public Output add(@PathVariable("a") int a, @PathVariable("b") int b) {
		System.out.println(a + " and  " + b);
		
		return new  Output(a+b) ;
	}

	@ApiOperation(value="Add two big integers")
	@GetMapping(path="/addBig/{a}/{b}" , produces="application/json")
	public OutputBig addBig(@PathVariable("a") BigInteger a, @PathVariable("b") BigInteger b) {
		System.out.println(a + " and  " + b);
		
		return new OutputBig( a.add(b) );
	}	
	
	
	@GetMapping("/error")
	public String error() {
		return "Some Error Occured";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
