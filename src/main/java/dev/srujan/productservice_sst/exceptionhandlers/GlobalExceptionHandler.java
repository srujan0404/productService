package dev.srujan.productservice_sst.exceptionhandlers;

import dev.srujan.productservice_sst.dtos.ExceptionDto;
import dev.srujan.productservice_sst.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException() {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBoundsException");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid productId " + productNotFoundException.getProductId() + " passed");
        dto.setResolution("ProductNotFoundException caught");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
