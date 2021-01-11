package com.example.owcrwanda.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsItem {
    String title;
    String description;
    String image_url;
    String external_url;
}
