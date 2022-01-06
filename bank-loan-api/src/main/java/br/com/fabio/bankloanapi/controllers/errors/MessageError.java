package br.com.fabio.bankloanapi.controllers.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
