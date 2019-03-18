package com.outreach.greenstar.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClsNotFoundException extends RuntimeException {

    public ClsNotFoundException(String exe) {
        super(exe);
    }
}
