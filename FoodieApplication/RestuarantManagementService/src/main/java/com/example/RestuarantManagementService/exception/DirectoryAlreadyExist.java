package com.example.RestuarantManagementService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Directory Already Exist")
public class DirectoryAlreadyExist extends Exception{
}
