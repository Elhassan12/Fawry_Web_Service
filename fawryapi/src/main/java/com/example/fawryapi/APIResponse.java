package com.example.fawryapi;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

    private boolean status;
    private String message;
    public T data;
}
