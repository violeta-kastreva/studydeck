package com.web.studydeck.model.service;

import java.util.List;

public class StacksDTO {
    String title;
    List<ResponseStacksDTO> stacks;

    public StacksDTO(List<ResponseStacksDTO> stacks) {
        this.stacks = stacks;
    }
}
