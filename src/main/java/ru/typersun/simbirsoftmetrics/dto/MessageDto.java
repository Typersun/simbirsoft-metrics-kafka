package ru.typersun.simbirsoftmetrics.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MessageDto {
    private String message;
    private String author;
}
