package com.mycompany.propery.management.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorModel {

    private String code;
    private String message;

    public ErrorModel(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
