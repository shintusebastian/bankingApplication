package co.pragra.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor //because we don't need a no arg constructor here
public class ErrorResponse {
    private int code;
    private String message;
    private Instant time;
    private String applicationId;
}
