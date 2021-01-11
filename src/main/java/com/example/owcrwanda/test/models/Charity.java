package com.example.owcrwanda.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Charity {
    String name;
    String description;
    String external_url;
    String logo_url;
}
